package com.sunbeam;

import java.util.Scanner;

public class BinarySearchMain {
	
	public static int binarySearch(int arr[], int key) {
		int left = 0, right = arr.length-1, mid;
		while(left <= right) {
			//1. find middle element of array
			mid = (left + right)/2;
			//2. compare key with middle element
			if(key == arr[mid])
				//3. if key is matching, then return index of middle element
				return mid;
			//4. if key is less than middle element, find key into left partition
			else if(key < arr[mid])
				right = mid - 1;
			//5. if key is greater than middle element, find key into right partition
			else
				left = mid + 1;
		}//6. repeat above steps till key is not found or partition is valid
		//7. if key is not found
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = binarySearch(arr, key);
		if(index == -1)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found at index : " + index);
		sc.close();

	}

}




