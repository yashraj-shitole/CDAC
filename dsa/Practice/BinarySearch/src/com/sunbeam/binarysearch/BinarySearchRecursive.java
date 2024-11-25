package com.sunbeam.binarysearch;

import java.util.Arrays;

public class BinarySearchRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,7,5,24,96,0,6,36,53,23,33,45,3};

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int key=96;
		System.out.println("Key : "+ key);
		int indexOfKey=binarySearchRecursive(arr, key, 0, arr.length);
		
		if (indexOfKey != -1) {
			System.out.println("Key found at index "+indexOfKey);
		}else {
			System.out.println("Key not found");
		}
		

	}

	
	
	public static int binarySearchRecursive(int[] arr, int key, int start, int end) {
		
		int mid=(start+end)/2;
		
		if(start>end) {
			return -1;
		}
		
		if(arr[mid]==key) {
			return mid;
		}
		else if(arr[mid]>key) {
			return binarySearchRecursive(arr, key, start, mid-1);
		}
		else {
			return binarySearchRecursive(arr, key, mid+1, end);
		}
		
		
	}
	
}
