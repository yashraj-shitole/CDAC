package Assignment04_Question01;


//1. Implement singly circular linked list using tail pointer (no head pointer). Compare time complexities of
//all operations.



public class Assignment04_Question01 {

	public static void main(String[] args) {
		

		SinglyCircularLinkedList sl=new SinglyCircularLinkedList();
		
		sl.addFirst(200);
		sl.addFirst(300);
		sl.addFirst(400);	
		sl.addLast(500);
		sl.addAt(700, 5);
		sl.addFirst(6000);
		
		
		sl.display();
		
//		sl.deleteFirst();
//		sl.deleteLast();
//		sl.deleteAt(7);
		
		
		
		sl.display();
	}

}



class SinglyCircularLinkedList{
	
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
		}
	}
	
	Node tail=null;
	int size=0;
	
	
	public void addFirst(int data) {
		Node newNode=new Node(data);
		
		if(tail==null ) {
			tail=newNode;
			tail.next=newNode;
			size++;
		}
		else {
			newNode.next=tail.next;
			tail.next=newNode;
			size++;

		}
		
	}
	
	public void addLast(int data) {
		Node newNode=new Node(data);
		
		if(tail==null) {
			addFirst(data);
			
		}
		else {
			newNode.next=tail.next;
			tail.next=newNode;
			tail=newNode;
			size++;
		}
		
		
	}
	
	public void addAt(int data,int position) {
		
		Node newNode=new Node(data);
		
		if(tail==null ) {
			addFirst(data);
		}
		else if(position==size || position>size) {
			addLast(data);
		}
		else{
			Node current=tail;
			for(int i=0;i<position ;i++) {
				current=current.next;
			}
			newNode.next=current.next;
			current.next=newNode;	
			size++;
		}
	}
	
	public void deleteFirst() {
		
		
		if(size==0 && size==1) {
			tail=null;
		}
		else {
		tail.next=tail.next.next;
		size--;
		}
	}
	
	
	public void deleteLast() {
		if(tail==null) {
			return;
		}
		else {

			Node current=tail.next;
			while(current.next!=tail) {
				current=current.next;
			}
			current.next=tail.next;
			tail=current;	
			size--;
		}
	}
	
	
	public void deleteAt(int position) {
		
		if(tail==null) {
			return;
		}
		else if(position==size || position>size) {
			deleteLast();
		}
		else {
			Node current=tail;
			
			for(int i=0;i<position-1;i++) {
				current=current.next;
			}
			
			current.next=current.next.next;
			size--;
			
		}
		
	}
	
	
	public void display(){
		if(size==0) {
			return;
		}
		else {
			
		
		Node current=tail.next;
		
		do{
			System.out.print(current.data+" ");
			current=current.next;
		}while(current!=tail.next);
		
		System.out.println();
		System.out.println("Size= "+size);
		}
	}
	
	
	
}
