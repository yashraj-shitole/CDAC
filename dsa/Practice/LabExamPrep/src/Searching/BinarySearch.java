package Searching;

public class BinarySearch {

	
	public int search(int[] arr,int key,int start,int end) {
		int mid=(start+end)/2;
		
		if(start>end) {
			return -1;
		}
		
		if(arr[mid]==key) {
			return mid;
		}
		else if(key>arr[mid]) {
			return search(arr, key, mid+1, end);
		}
		else {
			return search(arr, key, start, mid-1);
		}

	}
	
}
