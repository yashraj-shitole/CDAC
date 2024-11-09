
package Assignment01_Question05;


//5. Implement linear search algorithm to find the nth occurence of the given element. If nth occurrence is
//not found, return -1.

public class Assignment01_Question05 {

	public static void main(String[] args) {
		
		int[] arr= {2,2,3,2,1,3,5,3,6,7,8,9,3,3,7,5,6,4,7,4};
		int key=2;
		
		
		 int occurence=occurenceOfElement(arr,key);
		System.out.println(occurence);
		
	}

	private static int occurenceOfElement(int[] arr, int key) {
		
		int occurence=0;
		
		for(int i=0;i<arr.length;i++) {
			
			if(key==arr[i]) {
				occurence++;
			}
			
		}
		
		
		return occurence;
	}
	
	
	
	
	
	
}
