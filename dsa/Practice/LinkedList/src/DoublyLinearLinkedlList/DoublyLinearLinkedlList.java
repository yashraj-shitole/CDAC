package DoublyLinearLinkedlList;

public class DoublyLinearLinkedlList {
	
	
	class Node{
		Node previous;
		int data;
		Node next;
		      		
		public Node(int data) {

			this.data = data;
		}
		
		@Override
		public String toString() {
			return "Node [previous=" + previous + ", data=" + data + ", next=" + next + "]";
		}
		
	}
	
	Node head,tail;

	
	
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
		}
		else {
			newNode.next=head;
			head=newNode;
		}
		
	}
	
	
	public void addLast(int data) {
		
	}
	
	public void addAt(int data,int position) {
		
	}
	
	public void deleteFirst() {
		
	}
	
	public void deleteLast() {
		
	}
	
	public void deleteAt(int position) {
		
	}
	
	public void display() {
		
	}
	
	
}
