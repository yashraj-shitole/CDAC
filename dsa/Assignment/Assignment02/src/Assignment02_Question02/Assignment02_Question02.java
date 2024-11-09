package Assignment02_Question02;

//2. Implement circular queue using counter method (maintain count of values in queue and use that count
//to check empty and full)


public class Assignment02_Question02 {

	public static void main(String[] args) {
		
		CircularQueue cq=new CircularQueue(5);
		
		cq.push(12);
		cq.push(43);
		cq.push(33);
		cq.push(21);
		cq.push(24);
		cq.push(32);
		
		cq.peek();
		
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();
		cq.pop();

	}

}

class CircularQueue{
	
	int[] arr;
	int count;
	
	int front;
	int rear;
	int size;
	
	public CircularQueue(int size) {
		arr=new int[size];
		this.size=size;
	}
	
	public void push(int element) {
		
		if(count!=size-1) {			
			front=(front+1)%size;
			count++;
			arr[front]=element;
		}else {
			System.out.println("Queue is full");
		}

	}
	
	public void pop() {
		int element;
		if(count==0) {
			System.out.println("Queue empty");
		}else {
			element=arr[rear];
			rear=(rear+1)%size;
			count--;
			System.out.println(element);
		}

	}
	
	public void peek() {
		
		if(count==0) {
			System.out.println("Queue empty");
		}else {
			System.out.println(arr[rear]);
		}

	}
	
	
	
}
