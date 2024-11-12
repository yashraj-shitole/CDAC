package SinglyCircularLinkedList;

public class TestMain{
	
	public static void main(String[] args) {
	
		SinglyCircularLinkedList sl=new SinglyCircularLinkedList();
		
		sl.addFirst(200);
		sl.addFirst(400);
		sl.addFirst(300);
		sl.addFirst(100);
		
//		sl.addLast(1000);
		sl.display();
		
//		
		sl.addAt(900,7);
//		
		sl.display();

//		sl.deleteLast();
//		sl.deleteLast();
//		sl.deleteFirst();
//		sl.deleteFirst();
		sl.display();
//		
//		System.out.println("delete Last");
//		
//		sl.display();
//		
		sl.deteleAt(5);
		sl.display();
		System.out.println("Size= "+sl.getSize());
		
	}
}