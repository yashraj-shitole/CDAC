import java.util.Iterator;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayListImplimentation aList=new ArrayListImplimentation();
		
		
		for (int i = 0; i < 10000; i++) {
			aList.add(i);
		}
		
		for (int i = 0; i < 100; i++) {
			aList.remove(i);
		}
		
		
		
		
		
		aList.printArrayList();
		System.out.println("Size of array is "+aList.size());
		
		System.out.println("Internal array size "+aList.internalArrSize());
		
		
	}

}
