package Searching;

public class TestMain {

	public static void main(String[] args) {
		
		int[] arr= {3, 3, 3, 5, 5, 8, 22, 44, 65, 82};		
		BinarySearch bs=new BinarySearch();
		LinearSearch ls=new LinearSearch();
		
//		int index=bs.search(arr, 65, 0, arr.length);
		int index=ls.search(arr, 22);
		System.out.println(index);
		

	}

}
