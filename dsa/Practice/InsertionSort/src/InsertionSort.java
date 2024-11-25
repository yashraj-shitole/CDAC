import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		
int[] arr= {4,23,43,6,27,88,65,82,44,13,86,99,45,36,42};
		
		System.out.println(Arrays.toString(arr));
			
		insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void insertionSort(int[] arr) {
		
		
//		1. Pick one element of the array (start from 2nd index)
//		2. Compare picked element with all its left neighbours one by one
//		3. If left neighbour is greater, move it one position ahead
//		4. Insert picked element at its appropriate position 
//		5. Repeat above steps until array is sorted
		
		

		for(int i=1;i<arr.length;i++) {
			
			int temp=arr[i];
			int j;
			
			for(j=i-1;j>=0 && arr[j]>temp;j--) {
				
					arr[j+1]=arr[j];
				
				
			}
			arr[j+1]=temp;
			
			//Testing
			System.out.println();
			System.out.println("Step: "+(i+1));
			System.out.println(Arrays.toString(arr));
			
		}
		
	}

}
