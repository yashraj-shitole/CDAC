package Assignment01_Question02;

import java.util.Arrays;

//2. Write a program to print no of comparisions done to search a key in
//linear search
//binary serach


public class Assignment01_Question02 {
	
	public static void main(String[] args) {
		
		int[] arr= {4, 6, 13, 23, 27, 36, 42, 43, 44, 45, 65, 82, 86, 88, 99};
		int key=82;
		System.out.println("Key "+key);
		System.out.println("Array "+Arrays.toString(arr));
		int comparisonsLinearSearch= linearSearch(arr,key);
		
		System.out.println("Comparisions done in Linear Search "+ comparisonsLinearSearch);
		
		
		Arrays.sort(arr);
		int comparisonsBinarySearch= binarySearch(arr, key);
		System.out.println("Comparisions done in Binary Search "+ comparisonsBinarySearch);

	}

	private static int linearSearch(int[] arr,int key) {
		int comparisons = 0;
		
		for(int i=0;i<arr.length;i++) {
			comparisons++;
			
			if(key==arr[i]) {
				return comparisons;
			}
		}
		
		return comparisons;
	}

	private static int binarySearch(int[] arr,int key) {
		int start=0, end=arr.length;
		int comparisons = 0;
		
		while(start<=end) {
			comparisons++;
			int mid=(start+end)/2;
			
			if(key==arr[mid]) {
				return comparisons;
			}
			else if(key<arr[mid]) {
				end=mid-1;
			}else if(key>arr[mid]){
				start=mid+1;
			}
			
		}
		
		
		return comparisons;
	}

}
