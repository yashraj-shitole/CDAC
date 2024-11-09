package Assignment01_Question01;

//1. Write a linear search algorithm to return index of last occurance of key

public class Assignment01_Question01 {

	public static void main(String[] args) {
		
		
		int[] arr= {23,4,12,55,64,6,33,12,45,22,};
		int key=12;
		
		int index=getLastOccurance(arr,key);
		
		if(index != -1) {
			System.out.println("Last occurance of "+key+" is at index "+index);
		}
		else {
			System.out.println("Key not found in array");
		}

	}

	private static int getLastOccurance(int[] arr,int key) {
		
		//loop to iterate from last index of array to 0 index
		for(int i=arr.length-1;i>=0;i--) {
			
			if(key==arr[i]) {
				return i;
			}
		}
		
		return -1;
	}

}
