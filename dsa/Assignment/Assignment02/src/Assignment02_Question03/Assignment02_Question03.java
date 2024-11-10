package Assignment02_Question03;

import java.util.Arrays;

//3. Write program to implement linear queue in which front and rear starts at 0.

// -> only change rear increment condition in push method 

public class Assignment02_Question03 {

	public static void main(String[] args) {

		LinearQueue li=new LinearQueue(5);
		
		li.push(10);
		li.push(20);
		li.push(30);
		li.push(40);
		li.push(50);
		
		
		System.err.println(li.pop());
		System.err.println(li.pop());
		System.err.println(li.pop());
		System.err.println(li.pop());
		System.err.println(li.pop());
		System.err.println(li.pop());
	

		
	}

}

class LinearQueue{
	
	int[] arr;
	int front,rear;
	int size;
	


	public LinearQueue(int size) {
		this.size = size;
		arr=new int[size];
		front=rear=0; //front and rear start from 0
	}
	
	
	
	public void push(int value) {
		
		if(isFull()) {
			return;
		}
		arr[rear]=value;
		rear++; //rear incremented after assigning value as rear is already 0 at start
		
	}
	
	public int pop() {
		
		if(isEmpty()) {
			return 0;
		}
		return arr[front++];
		
	}
	
	public int peek() {
		
		return arr[front];
		
	}
	

	public boolean isFull() {
		
		return rear==size;
	}
	
	public boolean isEmpty() {
		
		return front==rear;
	}
	


	@Override
	public String toString() {
		return "LinearQueue [arr=" + Arrays.toString(arr) + ", front=" + front + ", rear=" + rear + ", size=" + size
				+ "]";
	}
	
	
}
