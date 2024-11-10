package Assignment03_Question01;

import java.util.*;

//1. Create an array of integers. Reverse the array using stack


public class Assignment03_Question01 {

	public static void main(String[] args) {
		
		
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.toString(arr));
		MyStack stack=new MyStack(arr.length);
		
		for(int i=0;i<arr.length;i++) {
			stack.push(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=stack.pop();
		}

		System.out.println(Arrays.toString(arr));
	}

}

class MyStack{
	
	
	int[] arr;
	int top=-1;
	
	
	public MyStack(int size) {
		arr=new int[size];
	}
	
	public void push(int element) {
		
		if(top==arr.length-1) {
			System.out.println("Stack full");
		}else {
			top++;
			arr[top]=element;
		}
		
		
		
	}
	
	public int pop() {
		
		int element=arr[top];
		top--;
		return element;
	}
	
	
	
	
}


