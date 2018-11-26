public class myNode{
		Object nodeValue ;
		myNode next ;

		public myNode(Object obj, myNode n) {
			nodeValue = obj ;
			next = n ;
		}

		public Object getNodeValue(){return nodeValue;}

		public myNode getNext(){return next;}

		public void setNodeValue(Object newVal){nodeValue = newVal;}

		public void setNext(myNode newNode){next=newNode;}
}
