package com.sunbeam;

import java.util.Arrays;

public class QuickSortMain {
	
	public static void quickSort(int arr[], int left, int right) {
		//0. stop if partition is invalid or partition has single element
		if(left >= right)
			return;
		//1. decide pivot element --> arr[left]
		//2. arrange less elements on left side of pivot
		//3. arrange greater elements on right side of pivot
		int i = left, j = right;
		while(i < j) {
			//a. find element which is greater than pivot
			for( ; i <= right && arr[i] <= arr[left] ; i++ );
			//b. find element which is lesser or equal than pivot
			for( ; arr[j] > arr[left] ; j--);
			//c. if i and j are not crossed then swap ith and jth element
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//d. if i and j are croosed then swap jth element with pivot
		int temp = arr[j];
		arr[j] = arr[left];
		arr[left] = temp;
		//4. sort left and right side of pivot seperately
		quickSort(arr, left, j - 1);
		quickSort(arr, j + 1, right);
	}

	public static void main(String[] args) {
		int arr[] = {66, 33, 99, 11, 77, 22, 55, 66, 88}; 
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		quickSort(arr, 0, arr.length-1);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}
