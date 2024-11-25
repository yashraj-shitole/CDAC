package com.sunbeam;

import java.util.Arrays;

public class HeapSortMain {

	public static void main(String[] args) {
		
		int arr[] = {0, 6, 14, 3, 26, 8, 18, 21, 9, 5};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		Heap h = new Heap();
		
		h.heapSort(arr);
	
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}
