package SinglyCircularLinkedList;

public class SinglyCircularLinkedList {
	
	class Node{
		
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		
	}
	
	Node head, tail;
	int size;
	
	
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
		Node newNode =new Node(data);
		
		if(head==null && tail==null) {
			head=tail=newNode;
			newNode.next=head;
			size++;
		}else {
			newNode.next=head;
			head=newNode;
			tail.next=head;
			size++;
		}
		
	}


	public void addLast(int data) {
		
		if(head==null) {
			addFirst(data);
		}else {
			Node newNode=new Node(data);
			
			tail.next=newNode;
			tail=newNode;
			newNode.next=head;
			size++;
		}
		
	}




	public void addAt(int data, int position) {
		if(head==null) {
			addFirst(data);
		}
		else if(position<1){
			addFirst(data);
		}
		else if(position>=size) {
			addLast(data);
		}else {
			Node newNode= new Node(data);
			Node current=head;
			for(int i=0;i<position-1;i++) {
				current=current.next;
			}
			
			newNode.next=current.next;
			current.next=newNode;
			
		}
		
	}
	




	public void deleteFirst() {
		
		if(head==null) {
			return;
		}
		else if(head.next==null) {
			head=tail=null;
			size--;
		}
		else{
			tail.next=head.next;
			head=head.next;
		size--;
		}
		
	}
	
	
	public void deleteLast() {
		
		if(head==null) {
			return;
		}
		if(head.next==null) {
			head=tail=null;
		}
		else {
			
			Node current=head;
			
			while(current.next!=tail) {
				current=current.next;
			}
			current.next=tail.next;
			tail=current;
			
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
		else if(position >=size) {
			deleteLast();
		}
		else {
			Node current=head;
		
			for(int i=0;i<position-1;i++) {
				current=current.next;
			}
			current.next=current.next.next;
			
			
		}
		
	}


	public int getSize() {
		return size;
	}
	
	
	public void display() {
		
		Node current=head;
		
		 do{
			System.out.print(current.data+" -> ");
			current=current.next;
		}while(current!=head);
		System.out.println("null");
		
	}

}
