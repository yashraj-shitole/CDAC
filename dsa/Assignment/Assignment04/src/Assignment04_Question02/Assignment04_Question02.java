package Assignment04_Question02;

//2. Implement stack and queue using linked list.

public class Assignment04_Question02 {

	public static void main(String[] args) {
		
		
		Stack stack=new Stack();
		
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.pop();
		stack.peek();	
		
		
		Queue queue=new Queue();
		
		
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(15);
		
		queue.front();
		queue.dequeue();
		queue.front();
		

	}

}


class Stack{
	
	LinkedList ll=new LinkedList();
	
	public void push(int data) {
		ll.addFirst(data);
	}
	
	public void pop() {
		System.out.println(ll.getFirst());
		ll.deleteFirst();
	}
	
	public void peek() {
		System.out.println(ll.getFirst());
	}
	
	
}

class Queue{
	
	
	LinkedList ll=new LinkedList();

	public void enqueue(int data) {
		ll.addFirst(data);
	}
	
	public void dequeue() {

		ll.deleteLast();
	}
	
	public void front() {
		ll.getLast();
	}
	
	
}

class LinkedList {
	static class Node{
		private int data;
		private Node next;
		public Node(int value) {
			data = value;
			next = null;
		}
	}
	
	
	private Node head;
	
	public LinkedList() {
		head = null;
	}
	
	public int getFirst() {
		return head.data;
	}
	
	public void getLast() {
		Node trav=head;
		while(trav.next != null) {
			trav = trav.next;
		}
		System.out.println(trav.data);
	}

	public void addFirst(int value) {
		Node newnode = new Node(value);
		newnode.next = head;
		head = newnode;
	}
	
	public void addLast(int value) {
		Node newnode = new Node(value);
		if(head == null)
			head = newnode;
		else {
			Node trav = head;
			while(trav.next != null)
				trav = trav.next;
			trav.next = newnode;
		}
	}

	
	public void deleteFirst() {
		if(head == null)
			return;
		head = head.next;
	}
	
	public void deleteLast() {
		if(head == null)
			return;
		else if(head.next == null)
			head = null;
		else {
			Node trav = head;
			while(trav.next.next != null)
				trav = trav.next;
			trav.next = null;
		}
	}
		
}
