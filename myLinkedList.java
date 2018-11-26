public class myLinkedList{
	public myNode head ;
	public int size;
	public myLinkedList(){
		head = null ;
		size = 0;
	}

	public Boolean IsEmpty(){
		if (head==null){return true;}
		else{return false;}
	}

		public void addInFront(Object o){
			myNode t = new myNode(o,null);
			t.setNext(head);
			head = t;
			size=size+1;
			
		}

		public myNode deleteFront() throws Exception{
			try{
				myNode temp = head ;
				head = head.getNext();
				temp.setNext(null) ;
				size=size-1;
				return temp ;
			}
			catch(Exception e){throw new Exception(e.getMessage());}
		}

		public Boolean contains(Object o){
			myNode ptr = head ;
			boolean ans = false;
			while(ptr != null){
				Object temp = ptr.getNodeValue(); 
				if (temp == o){ans=true;break;}
				else{ptr=ptr.next;}
			}
		return ans;
		}

		public int myLength(){
			return size;
	
		}
}