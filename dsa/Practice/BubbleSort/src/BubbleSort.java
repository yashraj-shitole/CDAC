import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr= {4,23,43,6,27,88,65,82,44,13,86,99,45,36,42};
		
		System.out.println(Arrays.toString(arr));
			
		bubbleSort(arr);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr) {
		
		
//		1. Compare all pairs of consecutive elements of the 
//		array one by one 
//		2. If right element is less than left element , swap both
//		3. Repeat above steps until array is sorted
		
		for(int i=0;i<arr.length;i++) {
			
			int swap=0;
			
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swap++;
				}
				
			}
			if(swap==0) {
				return ;
			}
			
			//Testing
			System.out.println();
			System.out.println("Step: "+(i+1));
			System.out.println(Arrays.toString(arr));
			
		}
	}

}
