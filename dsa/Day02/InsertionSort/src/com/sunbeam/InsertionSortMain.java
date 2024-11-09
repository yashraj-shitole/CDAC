package com.sunbeam;

import java.util.Arrays;

public class InsertionSortMain {
	
	public static void insertionSort(int arr[], int N) {
		for(int i = 1 ; i < N ; i++) {
			//1. pick one element of the array
			int temp = arr[i];
			int j;
			//2. compare picked element with all its left neighbours
			for(j = i - 1 ; j >= 0 && arr[j] > temp ; j--) {
				//3. if left neighbour is greater than picked data then move it one position ahead
				arr[j+1] = arr[j];
			}
			//4. insert picked data at its appropriate position
			arr[j + 1] = temp;
		}//5. repeat until array is sorted
	}

	public static void main(String[] args) {
		int arr[] = {55, 44, 22, 66, 11, 33};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		insertionSort(arr, arr.length);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}
