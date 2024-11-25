package com.sunbeam;


public class Heap {
	private int SIZE;
	
	public Heap() {
		SIZE = 0;
	}
	
	public void createHeap(int arr[]) {
		
		for(int i = 1 ; i < arr.length ; i++) {
			//1. increament size of heap by one
			SIZE++;
			//2. compare newly added element with all its ancestors
			int ci = SIZE;
			int pi = ci / 2;
			//3. repeat till root node
			while(pi >= 1) {
				//4. if parent is already maximum than child
				if(arr[pi] > arr[ci])
					break;
				//5. if parent is less than child then swap both
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//6. update parent and child index
				ci = pi;
				pi = ci / 2;
			}
		}
		
	}
	
	public void deleteHeap(int arr[]) {
		for(int i = 1 ; i < arr.length ; i++) {
			//1. swap first and last element of heap
			int max = arr[1];
			arr[1] = arr[SIZE];
			arr[SIZE] = max;
			//2. decrese size of heap by 1
			SIZE--;
			//3. compare root element with all its descendents
			int pi = 1;
			int ci = pi * 2;
			while(ci <= SIZE) {
				//4. find index of max child of parent
				if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				//5. if parent is already maximum than max child
				if(arr[pi] > arr[ci])
					break;
				//6. if parent is less than max child, then swap both
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//7. update parent and child index
				pi = ci;
				ci = pi * 2;
			}
		}
	}
	
	public void heapSort(int arr[]) {
		//1. create heap
		createHeap(arr);
		//2. delete heap
		deleteHeap(arr);
	}

}
