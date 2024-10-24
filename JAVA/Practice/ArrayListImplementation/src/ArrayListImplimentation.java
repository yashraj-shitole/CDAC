
public class ArrayListImplimentation  {

	
	int arraysize=10;
	int pointer=0;
	int[] arrayList=new int[arraysize];
	int[] tempList;
	
	
	
	//return arrayList size
	public int size() {
		return pointer;
	}
	
	//return internal array length
	public int internalArrSize() {
		return arrayList.length;
	}
	
	public ArrayListImplimentation(){
	}
	
	public ArrayListImplimentation(int[] arr){
		arrayList=arr;
	}
	
	
	//add element
	public void add(int element) {
		
		if((pointer+1)>arrayList.length) {
			increaseSize();
		}
		arrayList[pointer]=element;
		pointer++;
	}
	
	
	//remove element
	public void remove(int index) {
		
		if(index < pointer) {			
			for(int i=index;i<pointer-1;i++) {
				arrayList[i]=arrayList[i+1];
			}
			pointer--;
		}
		else {
			System.out.println("Index is greater than size of array");
		}
		if((pointer+1)%5==0) {
			decreaseSize();
		}
	}
	
	
	//increase array size
	public void increaseSize() {
		
		tempList=new int[arraysize];
		for(int i=0;i<pointer;i++) {
			tempList[i]=arrayList[i];
		}
		
		arraysize=(int) (arraysize*1.5);
		
		arrayList=new int[arraysize];
		
		for(int i=0;i<pointer;i++) {
			arrayList[i]=tempList[i];
		}
		
		tempList=new int[0];
		
	}
	
	//decrease array size
	public void decreaseSize() {
		
		tempList=new int[arraysize];
		
		for(int i=0;i<pointer;i++) {
			tempList[i]=arrayList[i];
		}
		
		arraysize=pointer+1;
		
		arrayList=new int[arraysize];
		
		for(int i=0;i<pointer;i++) {
			arrayList[i]=tempList[i];
		}
		
		tempList=new int[0];

		
	}
	
	
	public void printArrayList() {
		for(int i=0;i<pointer;i++) {
			System.out.print(arrayList[i]+" ");
		}
		System.out.println();
	}
	
	
}
