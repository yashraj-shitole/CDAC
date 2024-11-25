package SinglyLinearLinkedList;

public class TestMain{
	
	public static void main(String[] args) {
	
		SinglyLinkedList sl=new SinglyLinkedList();
		
		sl.addFirst(200);
		sl.addFirst(400);
		sl.addFirst(300);
		sl.addFirst(100);
		
		sl.addLast(1000);
		sl.display();
		
		
		sl.addAt(900,6);
		
		sl.display();

		
		sl.deleteFirst();
		sl.display();
		
		System.out.println("delete Last");
		
		sl.display();
		
		sl.deteleAt(0);
		sl.display();
		System.out.println("Size= "+sl.getSize());
		
		System.out.println(sl.head.toString());
		
		
	}
}