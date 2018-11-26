import java.util.*;

public class Exchange{
	int exid ;
	Exchange parent;
	MobilePhoneSet mobSet = new MobilePhoneSet();
	ExchangeList childs = new ExchangeList();

	public Exchange(int number){
		exid = number;
		parent = null;
	}

	public Exchange parent(){
		return parent;
	}


	public int numChildren(){
		int l = childs.exlst.myLength() ;
		return l ;

	}


	public Exchange child(int i) throws Exception{
		if(i<= this.numChildren()){
			myNode ptr = this.childs.exlst.head;
			while(i>1){
				ptr=ptr.next ;
				i=i-1;
			}
			Exchange a = (Exchange)ptr.nodeValue;
			return a;
		}
		else{throw new Exception("Error - child Index out of bounds");}
		
	}


	public Boolean isRoot(){
		if (parent==null){return true;}
		else{return false;}
	}


	public RoutingMapTree subtree(int i) throws Exception{
		if (i<= this.numChildren()){		
			RoutingMapTree a = new RoutingMapTree() ;

			try{
				a.root = child(i) ;
			}
			catch(Exception e){throw new Exception(e.getMessage());}
			return a;
		}
		else{throw new Exception("Error - subtree Index out of bounds");}
	}

	
	public MobilePhoneSet residentSet(){
		return mobSet;
	}

}