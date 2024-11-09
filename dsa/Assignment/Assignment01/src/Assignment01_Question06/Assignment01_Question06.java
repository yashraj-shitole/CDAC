package Assignment01_Question06;


//6. Find the first non-repeating element: Input: { 1, 2, 3, -1, 2, 1, 0, 4, -1, 7, 8 } Ouput: 3


public class Assignment01_Question06 {

	public static void main(String[] args) {
		
		
		int[] arr={ 1, 2, 3, -1, 2,3,-1,0,7,8,4, 1, 0, 4, -1, 7, 8};
		
		
		String element=firstNonRepeatingElement(arr);
		System.out.println(element);
		

	}

	private static String firstNonRepeatingElement(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			int occurence=0;
			
			for(int j=0;j<arr.length;j++) {
				
				if(arr[i]==arr[j]) {
					occurence++;
				}
				if(j==arr.length-1 && occurence==1) {
					return Integer.toString(arr[i]);
				}
			}
		}
		
		
		
		return "Not Found";
	}
	
	
	

}
