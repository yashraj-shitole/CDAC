package Sorting;

public class InsertionSort {

	public int[] sort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			int temp=arr[i];
			
			int j;
			for(j=i-1;j>=0 && arr[j]>temp;j--) {
				arr[j+1]=arr[j];
			}
			
			arr[j+1]=temp;
		}
		
		return arr;
	}
	
	

}

