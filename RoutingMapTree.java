import java.util.*;

public class RoutingMapTree{

	Exchange root = new Exchange(0);

	public RoutingMapTree() {
			root.exid = 0;
		}

	public Boolean containsNode(Exchange a) throws Exception{
		try{
			Boolean ans = false;
			
			if (root.exid==a.exid){ans = true;}
				
			else{
				int i = root.numChildren() ;
				
					while(i>0){
						ans = ans || root.subtree(i-1).containsNode(a) ;
						i=i-1;
					}
			}
			return ans;
		}
			catch(Exception e){throw new Exception(e.getMessage());}
	}


		public Boolean containsNodeWithId(int a) throws Exception{
		try{
			Boolean ans1 = false;
			
			if (root.exid==a){ans1 = true;}
				
			else{
				int i = root.numChildren() ;
				
					while(i>0){
						ans1 = ans1 || root.subtree(i-1).containsNodeWithId(a) ;
						i=i-1;
					}
			}
			return ans1;
		}
			catch(Exception e){throw new Exception(e.getMessage());}
		}


	public void switchOn(MobilePhone a, Exchange b) throws Exception{

			a.status = true;
			a.base = b;									
			Exchange ptr = b;
			b.mobSet.mset.Insert(a);
			while(ptr.parent != null){					
				ptr.parent.mobSet.mset.Insert(a) ;

				ptr = ptr.parent ;
			}
	}


	public void switchOff(MobilePhone a)  throws Exception{
			if(a.status==true){
				try{
					this.root.mobSet.mset.Delete(a);
					Exchange tbase = a.location();
					a.switchOff();

					while(tbase.parent != null){
						tbase.mobSet.mset.Delete(a);
						tbase = tbase.parent ;
					}
				}
				catch(Exception e){throw new Exception(e.getMessage());}
			}
			else{throw new Exception("Error - MobilePhone "+ a.num + " is already OFF");}
			
		}

	public Exchange findNode(int a) throws Exception{
		Exchange ans = root;
		
			if(root.exid == a){
				
				ans= root;
			}
			else{

				int n = root.numChildren();

				Exchange atemp = new Exchange(a);

				try{
					for(int j=0;j<n;j++){
						if(root.subtree(j).containsNodeWithId(a)){
							ans = root.subtree(j).findNode(a);
						}
					}
				}
				catch(Exception e){throw new Exception(e.getMessage());}
			}
			return ans;
		

		
	}



	public void addExchange(int a, int b) throws Exception{
			try{
				Exchange aex = this.findNode(a);
			

			Exchange bex = new Exchange(b);

			aex.childs.exlst.addInFront(bex);
			bex.parent = aex ;
			}
			catch(Exception e){throw new Exception(e.getMessage()); }
	}



	public void performAction(String actionMessage) {
		//try{
			//System.out.println(actionMessage);

			if (actionMessage.charAt(4)=='x'){
				int i = 0;
				actionMessage = actionMessage.substring(12);
				while(actionMessage.charAt(i)!=' '){i=i+1;}
				String a = actionMessage.substring(0,i);
				String b = actionMessage.substring(i+1);

				int aexid = Integer.parseInt(a);
				int bexid = Integer.parseInt(b);

				try{
					this.addExchange(aexid,bexid);
				}
				catch(Exception e){System.out.println(e.getMessage());}
				

			}


			else if (actionMessage.charAt(7)=='n'){
				int i = 0;
				actionMessage = actionMessage.substring(15);
				while(actionMessage.charAt(i)!=' '){i=i+1;}
				String a = actionMessage.substring(0,i);
				String b = actionMessage.substring(i+1);

				int anum = Integer.parseInt(a);
				int bexid = Integer.parseInt(b);

				//Exchange btemp = new Exchange(bexid);

				try{
				
				
					Exchange bex = this.findNode(bexid);
				

					MobilePhone amob = new MobilePhone(anum);
					amob.status = false;

					
					this.switchOn(amob,bex);

					}
				catch(Exception e){System.out.println(e.getMessage());}

					//int n = bex.mobSet.mset.lst.myLength();
                
			

			}


			else if (actionMessage.charAt(7)=='f'){
				String a = actionMessage.substring(16);

				int anum = Integer.parseInt(a);

				MobilePhoneSet tset = this.root.mobSet ;
				int nl = tset.mset.lst.myLength();
				myNode tnode = tset.mset.lst.head;

				for(int i=0;i<nl;i++){
					MobilePhone txt = (MobilePhone)tnode.nodeValue;
					if(txt.num == anum){break;}
					tnode=tnode.next ;
				}

				MobilePhone tmob = (MobilePhone)tnode.nodeValue ;


				try{this.switchOff(tmob);}
				catch(Exception e){System.out.println(e.getMessage());}
				

			}


			else if(actionMessage.charAt(5)=='N'){
				int i = 0;
				String amt = actionMessage ;
				actionMessage = actionMessage.substring(14);
				while(actionMessage.charAt(i)!=' '){i=i+1;}
				String a = actionMessage.substring(0,i);
				String b = actionMessage.substring(i+1);

				int aexid = Integer.parseInt(a);
				int bth = Integer.parseInt(b);

				Exchange atemp = new Exchange(aexid);

				try{
					Exchange aex = this.findNode(aexid);
				
					int nx = aex.numChildren();

					Exchange bex = aex.child(nx-bth);

					System.out.println(amt + ": "+bex.exid);
					}
				catch(Exception e){System.out.println(e.getMessage());}

			}

			else if(actionMessage.charAt(5)=='M'){
				String a = actionMessage.substring(20);

				int aexid = Integer.parseInt(a);

				//Exchange atemp = new Exchange(aexid);

				try{
					Exchange aex = this.findNode(aexid);
				

					int n = aex.mobSet.mset.lst.myLength();
					myNode ptr = aex.mobSet.mset.lst.head ;

					String s = "" ;

					while(ptr != null){	
						MobilePhone tnx = (MobilePhone)ptr.nodeValue;
						s = tnx.num +", "+s ;
						ptr = ptr.next;
					}
					s = actionMessage + ": " + s ;
					int sl = s.length();
					s = s.substring(0,sl-2);
					System.out.println(s);

					}
				catch(Exception e){System.out.println(e.getMessage());}
					
				
			}
		
	}
}