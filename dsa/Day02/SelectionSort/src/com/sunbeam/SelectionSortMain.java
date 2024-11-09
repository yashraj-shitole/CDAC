package com.sunbeam;

import java.util.Arrays;

public class SelectionSortMain {
	
	public static void selectionSort(int arr[], int N) {
		for(int i = 0 ; i < N-1 ; i++) {
			//1. select one position of the array --> i
			//2. Find smallest element out of remaining elements
			int minIndex = i;
			for(int j = i + 1 ; j < N ; j++) {
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}
			//3. swap smallest element and selected position element
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
			
		}//4. repeat above steps untill array is sorted
	}

	public static void main(String[] args) {
		int arr[] = {44, 11, 55, 22, 66, 33};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		selectionSort(arr, arr.length);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}






