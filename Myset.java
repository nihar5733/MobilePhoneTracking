public class Myset{

	public myLinkedList lst = new myLinkedList() ;

	//public void Myset(){lst.head.nodeValue = 0;lst.head.next = null;}

	public Boolean IsEmpty() {
		if (lst.IsEmpty()) {return true ;}
		else {return false;}
	}


	public Boolean IsMember(Object o) {
		if (this.lst.contains(o)){return true;}
		else{return false;}
	}


	public void Insert(Object o){
		if(!this.lst.contains(o)){
			this.lst.addInFront(o);
		}
	}


	public void Delete(Object o) throws Exception{

			if(lst.contains(o)){
				myNode ptr1 = lst.head ;
				if (ptr1.next != null){
					myNode ptr2 = ptr1.next;
					while(ptr2.nodeValue !=o && ptr1.nodeValue != o){ptr1 = ptr1.next; ptr2 = ptr2.next;}
					if(ptr1.nodeValue==o){lst.head = ptr1.next;ptr1.next=null;}
					else{
						ptr1.next = ptr2.next;
						ptr2.next = null;
					}
				}
				else{lst.head = null;}
			}
			else{throw new Exception("Error - Object does not belong to the set");}
		}

	
	public Myset Union(Myset a){
		Myset c = new Myset();c = a ;
		myNode ptr = new myNode(lst.head.nodeValue,lst.head.next);
		//ptr = lst.head ;
		while(ptr != null){
			if(c.IsMember(ptr.nodeValue)){ptr=ptr.next;}
			else{
				c.Insert(ptr.nodeValue);
			}
		}
		return c;
	}


	public Myset Intersection(Myset a){
		Myset d = new Myset() ;
		myNode ptr = new myNode(lst.head.nodeValue,lst.head.next);
		while(ptr != null){
			if(a.IsMember(ptr.nodeValue)){
				d.Insert(ptr.nodeValue);
				ptr=ptr.next;
			}
			else{
				ptr=ptr.next;
			}
		}
		return d ;
	}
}