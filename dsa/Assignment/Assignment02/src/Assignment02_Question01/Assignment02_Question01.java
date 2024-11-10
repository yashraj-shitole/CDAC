package Assignment02_Question01;

import java.util.*;

//Modify the insertion sort algorithm to sort the array in descending order

public class Assignment02_Question01 {

	public static void main(String[] args) {
		
		
		int[] arr= {55,44,22,66,11,33};
		
		System.out.println(Arrays.toString(arr));
		
		InsirtionSort is=new InsirtionSort();
		
		is.insertionSort(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}


class InsirtionSort{
	
	public void insertionSort(int arr[], int length) {
		
		for(int i=1;i<length;i++) {
			
			int temp=arr[i];
			int j;
			
			for(j=i-1;j>=0 && arr[j] < temp;j-- ) {
				arr[j+1]=arr[j];
			}
			
			arr[j+1]=temp;
			
		}
	}
}
