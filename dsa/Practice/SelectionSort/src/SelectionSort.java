import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr= {4,23,43,6,27,88,65,82,44,13,86,99,45,36,42};
		
		System.out.println(Arrays.toString(arr));
			
		selectionSort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		
		
	}

	private static void selectionSort(int[] arr) {
		
		// 1. Select one position of the array
		for(int i=0;i<arr.length;i++) {
			int indexOfSmallest=i;
			
			//2. Find smallest element out of remaining elements
			for(int j=i;j<arr.length;j++) {
				if(arr[indexOfSmallest]>arr[j]) {
					indexOfSmallest=j;
				}	
			}
			
			//3. Swap selected position element and smallest element
			if(arr[i]>arr[indexOfSmallest]) {
				int temp=arr[indexOfSmallest];
				arr[indexOfSmallest]=arr[i];
				arr[i]=temp;
			} //4. Repeat above steps until array is sorted
			
			
			//Testing
			System.out.println();
			System.out.println("Step: "+(i+1));
			System.out.println(Arrays.toString(arr));
			
		}
		
		
		
		
	}
}
