package Assignment03_Question03;

//3. In singly linear list implement following operations.
//insert a new data after a given data
//insert a new data before a given data


public class Assignment03_Question03 {
	
	public static void main(String[] args){

	LinkedList li=new LinkedList();
	
	li.insert(50);
	li.insert(20);
	li.insert(30);
	li.insert(40);
	li.insert(10);
	  
	li.displayList();
	
	System.out.println();
	li.insertAfter(100,30);
	
	
	li.displayList();
	System.out.println();
	
	
	
	li.insertBefore(100,10);
	
	
	
	li.displayList();
	
	
	}

}


class LinkedList{
	
	
	Node head=null;

	
	static class Node{
		int data;
		Node next;	
		public Node(int data) {
		this.data=data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		
		
		
	}
	
	
	public void insert(int element) {
		Node newNode=new Node(element);
			newNode.next=head;
			head=newNode;
			
			
	}
	
	
	public void insertAfter(int element,int data) {
		
		Node newNode=new Node(element);
		
		if(head==null) {
			return;
		}
		
		else if(head.data==data){
			Node trav=head;

			newNode.next=trav.next;
			trav.next=newNode;
			
		}
		
		else {
			Node trav=head;
			
			while(trav.next!=null && trav.data!=data) {
				trav=trav.next;
			}
			
			newNode.next=trav.next;
			trav.next=newNode;
			
		}
	}

	
	public void insertBefore(int element,int data) {
		
		Node newNode=new Node(element);
		
		if(head==null) {
			return;
		}
		
		else if(head.data==data){
			insert(data);
		}
		else {
			Node trav=head;
			
			while(trav.next!=null) {
				if(trav.next.data==data) {	
					break;
				}
				trav=trav.next;
				System.out.println(trav);
			}
			
			newNode.next=trav.next;
			trav.next=newNode;
			
			
			
			
		}
		
	}




	public void displayList() {
		Node trav=head;
		
		while(trav!=null) {
			System.out.print(trav.data+" ");
			trav=trav.next;
		}
	}
	
}
