package SinglyLinearLinkedList;



 public class SinglyLinkedList {

	
	
	class Node{
		
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
	}
	
	
	Node head;
	int size=0;
	
	public SinglyLinkedList() {
		// TODO Auto-generated constructor stub
		head=null;
	}
	
	/* 
	 addFirst
	 addLast
	 addAt
	 deleteFirst
	 deleteLast
	 deteleAt
	 display
	 search
	 */
	
	
	public void addFirst(int data) {
		
		Node newNode=new Node(data);
		
		if(head==null) {
			head=newNode;
			size++;
		}else {
			newNode.next=head;
			head=newNode;
			size++;
		}
		
	}
	
	public void addLast(int data) {
		
		Node newNode=new Node(data);
		
		Node current=head;
		
		if(head==null) {
			addFirst(data);
		}else {
			
			while(current.next!=null) {
				current=current.next;
			}
			current.next=newNode;
			size++;
		}
		
	}
	
	public void addAt(int data, int position) {
		
		Node newNode=new Node(data);
		
		if(head==null || position<1 ) {
			addFirst(data);
		}
		else if (position==size || position>size) {
			addLast(data);
		}
		else {
			Node current=head;
		for(int i=0;i<position-1;i++) {
			current=current.next;
		}
		
		newNode.next=current.next;
		current.next=newNode;
		
		size++;
		}

	}
	
	
	public void deleteFirst() {
		
		if(head==null) {
			return;
		}
		
		else {
			head=head.next;
			size--;
		}
		
	}
	
	 public void deleteLast() {
		 
		 if(head == null || head.next==null) {
			 deleteFirst();
		 }
		 else {
			 
			 Node current=head;
			 
			 while(current.next.next!=null) {
				 current=current.next;
			 }
			 
			 current.next=null;
			 
			 size--;
		 }
		 
		 
	 }
	 
	 public void deteleAt(int position) {
		
		 if(head==null) {
			 return;
		 }
		 else if(position<1) {
			 deleteFirst();
		 }
		 else if(position==size || position>size) {
			 deleteLast();
		 }
		 else {
			 
			 Node current=head;
			 
			 for(int i=0;i<position-1;i++) {
				 current=current.next;
			 }
			 
			 current.next=current.next.next;
			 
			 size--;
		 }
		 
	 }
	
	
	public int getSize() {
		return size;
	}
	
	public void display() {
		Node current=head;
		
		while(current!=null) {
			System.out.print(current.data+" -> ");
			current=current.next;
		}
		System.out.println("null");
	}
	
	
	
}
