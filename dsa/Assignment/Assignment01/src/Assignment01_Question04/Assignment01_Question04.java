package Assignment01_Question04;

import java.util.Arrays;

//4. Implement binary search algorithm if array is sorted in descending order



public class Assignment01_Question04 {

	public static void main(String[] args) {
		
		int[] arr= {89,67,56,44,32,23,16,11,8,3,1};
		int key=11;
		
		
		System.out.println(Arrays.toString(arr));

		
		int index=binarySearchDesc(arr,key);
		
		if(index != -1) {
			System.out.println("Found at "+ index);
		}
		else {
			System.out.println("Not found");
		}

		
	}

	private static int binarySearchDesc(int[] arr,int key) {
		int start=0,end=arr.length;
		
		
		while(start<=end) {
			
			int mid=(start+end)/2;
			
			if(key==arr[mid]) {
				return mid;
			}
			else if(key>arr[mid]) {
				end=mid-1;
			}
			else if(key< arr[mid]) {
				start=mid+1;
			}
			
		}
		
		
		
		return -1;
	}

}
