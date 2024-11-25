package Assignment03_Question02;

//2. Implement circular queue using counter method (maintain count of values in queue and use that count
//to check empty and full)


public class Assignment03_Question02 {

	public static void main(String[] args) {
		
		CircularQueue cq=new CircularQueue(5);
		
		cq.push(12);
		cq.push(43);
		cq.push(33);
		cq.push(21);
		cq.push(44);
		cq.push(13);
		cq.push(2);
		
		
		System.out.println("Peek");
		cq.peek();
		
		System.out.println("Pop");
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
	int count=0;
	
	int front=0;
	int rear=0;
	int size;
	
	public CircularQueue(int size) {
		arr=new int[size];
		this.size=size;
	}
	
	public void push(int element) {
		
	
		if(count == size){
			System.out.println("Queue is full");
			return;
		}
		else{			
			front=(front+1)%size;
			count++;
			arr[front]=element;
			System.out.println(element+" added");
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
			System.out.println(element+" deleted");
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
