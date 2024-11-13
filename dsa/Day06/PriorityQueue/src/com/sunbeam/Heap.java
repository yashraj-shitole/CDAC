package com.sunbeam;

public class Heap {
	private int arr[];
	private int SIZE;
	
	public Heap(int size) {
		arr = new int[size + 1];
		SIZE = 0;
	}
	
	public void addHeap(int value) {
		//0. increament heap size by one
		SIZE++;
		//1. add value at first empty location from left side
		arr[SIZE] = value;
		//2.find correct position of newly added element,
			// by compairing with all ancestors one by one
		int ci = SIZE;
		int pi = ci / 2;
		while(pi >= 1) {
			//3. if parent is already greater than its child
			if(arr[pi] > arr[ci])
				break;
			//4. if parent is less than its child, then swap parent and child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			//5. update parent and child index
			ci = pi;
			pi = ci / 2;
		}
	}
	
	public int deleteHeap() {
		//1. take backup of maximum value(root element)
		int max = arr[1];
		//2. place last value of heap at index 1 (root position)
		arr[1] = arr[SIZE];
		//3. decrement size of heap by one
		SIZE--;
		//4. find correct position of element which is placed at root index
			// by compairing with all its descendents
		int pi = 1;
		int ci = pi * 2;
		while(ci <= SIZE) {
			//5. find index of max child
			if( (ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			//6. if max child is already less than its parent, then stop
			if(arr[ci] < arr[pi])
				break;
			//7. if max child is greater than its parent, then swap parent and max child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			//8. update parent and child indices
			pi = ci;
			ci = pi * 2;
		}		
		//9. return max value / root element / deleted value
		return max;
	}
	
	public boolean isEmpty() {
		return SIZE == 0;
	}
	
	public boolean isFull() {
		return SIZE == arr.length - 1; 
	}
	
	public int getMax() {
		return arr[1];
	}

}















