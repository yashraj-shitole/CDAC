package LinkedList;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList dl=new DoublyLinkedList();
		
		dl.addFirst(new Student(1, "Yashraj", 1));
		dl.addFirst(new Student(2, "Yashraj", 1));
		dl.addFirst(new Student(3, "Yashraj", 1));
		dl.addFirst(new Student(4, "Yashraj", 1));
		
		dl.display();

	}

}
