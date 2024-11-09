package Assignment01_Question07;

//7. Find rank of an element in an array of integers. rank: rank of a given integer "x" in the array, is "total no.
//of ele's less than or equal to x (including x). Input: { 10, 20, 15, 3, 4, 4, 1 } Ouput: Rank of 4 is: 4


public class Assignment01_Question07 {
	
	
	 public static void main(String[] args) {
	      int arr[]= {10,20,15,3,4,4,1};
	      
	      int key=10;
	      int rank=countRank(arr,key);
	      System.out.println("Rank of "+key+" is :"+rank);
}

	 
	 
	 public static int countRank(int arr[],int key) {
		   int count=0;
		   for(int i=0; i<arr.length; i++) {
			   if(arr[i]<=key) {
				   count++;
			   }
		   }
		   return count;
	   }
    
	
}
