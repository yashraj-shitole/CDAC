package Sorting;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
int[] arr= {5,3,5,8,22,65,3,44,82,3};
		
		InsertionSort is=new InsertionSort();
		
		SelectionSort ss=new SelectionSort();
		
		System.out.println(Arrays.toString(ss.sort(arr)));
		

	}

}
