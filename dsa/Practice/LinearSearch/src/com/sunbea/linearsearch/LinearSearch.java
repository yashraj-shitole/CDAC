package com.sunbea.linearsearch;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,2,3,7,5,24,96,0,6,36,53,23,33,45,3};
		
		
		int indexOfKey=linearSearch(arr, 3);
		
		if(indexOfKey != -1) {
			System.out.println("Key found at index "+indexOfKey);
		}else {
			System.out.println("Element not found");
		}
		

	}
	
	
	
	public static int linearSearch(int[] arr,int key) {
		
		
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		
		
		return -1;
	}

}
