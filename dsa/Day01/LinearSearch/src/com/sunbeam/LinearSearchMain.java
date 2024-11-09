package com.sunbeam;

import java.util.Scanner;

public class LinearSearchMain {
	
	public static int linearSearch(int arr[], int key) {
		//1. traverse array from 0 to N-1 index
		for(int i = 0 ; i < arr.length ; i++) {
			//2. compare key with each array element
			if(key == arr[i])
				//3. if key is matching, then return index
				return i;
		}
		//4. if key is not found, then return -1
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 14};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = linearSearch(arr, key);
		if(index == -1)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found at index : " + index);
		
		
		sc.close();

	}

}
