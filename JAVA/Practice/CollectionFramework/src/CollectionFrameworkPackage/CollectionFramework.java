package CollectionFrameworkPackage;

import java.util.*;

public class CollectionFramework {

	public static void main(String[] args) {

		//----------------------------------------
		//Iterable interface is root interface of collection classes
		//It is designed to use wiht for loop allowing simpler iteration over collections
		//any class implements Iterable can be target of foreach loop
		//when class implements iterable then it is must to override iterator
		//foreach internally use iterator
		//for each repeatedly calls hasNext() to check if more elements are available if it returns true it calls next()
		
		
		//----------------------------------------
		//Collection interface
		Collection<Integer> collectionArrayList=new ArrayList<>();	
		collectionArrayList.add(1);
		collectionArrayList.add(2);
		
		//----------------------------------------
// A] List Interface
		//represents ordered collection known as sequential
		//provides way to store and manipulate collection of elements while preserving there order
		List<Integer> listArrayList=new ArrayList<>();
		listArrayList.add(1);
		listArrayList.add(10);
		
		//List implements
			//1. ArrayList
			//2. LinkedList
			//3. Vector
			//4. Stack<E>
		
		//-----------------------------------------------
	//1. ArrayList
		//Resizable array implementation of List interface
		//elements are maintained in order
		//allow NULL and duplicate
		//Index based access
		//Implements random access
		//Not sunchronized - not thread safe
		// Uses regular array to store elements when array gets full new array with larger size is created and elements are copied over new array
		//when more space is needed array size is increased by approximately 50%
		ArrayList<Integer> arrayList1=new ArrayList<>();
		ArrayList<Integer> arrayList2=new ArrayList<>(20); //arraylist with initial capacity
		ArrayList<Integer> arrayList3=new ArrayList<>(arrayList1); //copies all elements of given list to created list
		
		arrayList1.add(10);
		arrayList1.add(20);
		arrayList1.add(30);
		arrayList1.add(40);
		System.out.println(arrayList1.get(0)); //to get element at index
		System.out.println(arrayList1.set(0, 50));
		System.out.println(arrayList1.remove(0));  //removes from ArrayList
		arrayList1.addAll(arrayList3);
		arrayList1.indexOf(20);
		arrayList1.size();
		arrayList1.clear();
		arrayList3.trimToSize(); //to minimize array to save extra space
		ArrayList<Integer> arrayList4= (ArrayList<Integer>) arrayList1.clone();
		for(Integer a: arrayList1) { //for each loop as Collection interface implements Iterable interface
			System.out.println(a);
		}
		
		//-----------------------------------------------
	//2. Vector
		//resizable array 
		//elements are maintained in order
		//allow null and duplicates
		//Index based access
		//Implements random access
		//Synchronized and is thread safe ------------main difference between ArrayList and Vector
		//when Vector needs to increase size it increases by given --CAPACITY INCREMENT-- 
		//when no Capacity Increment is specified it increases by --DOUBLE of its size --
		
		Vector<Integer> vector1=new Vector<>();
		Vector<Integer> vector2=new Vector<>(20); //initial size
		Vector<Integer> vector3=new Vector<>(20,10); //initial size and capacity increment
		Vector<Integer> vector4=new Vector<>(vector1);
		
		vector1.add(10);
		vector1.add(20);
		vector1.add(30);
		vector1.add(40);
		vector1.add(50);
		System.out.println(vector1.get(0));
		vector1.set(0, 10);
		vector1.remove(0);
		vector1.addAll(vector4);
		vector1.addAll(2, vector4); //to add from specific index
		vector1.indexOf(vector4);
		vector1.clear();
		for(Integer v:vector1) {
			System.out.println(v);
		}
		
		//------------------------------------------------
	//3.Stack
		//Implements LIFO datastructure
		//Extends vector
		//thread safe -synchronizes
		//maintains order
		
		Stack<Integer> stack=new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.pop();
		System.out.println(stack.empty()); //checks is empty or not if yes returns true
		System.out.println(stack.search(20)); //search element and returns index if not found rerurns -1
		
		//-------------------------------------------------
// B] Queue
		//queue represents collection designed for holding elements prior to processing
		//urpose is to hold elements in specific order 
		//implements FIFO
		//allows duplicates
		//Null are not allowed but implementations like LinkedList may allow
		//has subtypes like Blocking and non-Blocking
		
		Queue<Integer> queue1=new PriorityQueue<>();
		
		queue1.add(10);
		queue1.add(20);
		queue1.add(30);
		queue1.add(40);
		System.out.println(queue1.offer(20)); //same as add but returns true after adding
		System.out.println(queue1.remove()); // removes head of queue if empty gives exception
		System.out.println(queue1.poll()); //removes head if not present returns null
		System.out.println(queue1.element()); //returns head without removing if empty gives exception
		System.out.println(queue1.peek()); //returns head without removing if empty returns null
		
		//Queue implements
			//1. LinkedList
			//2. PriorityQueue
			//3. ArrayDequeue
		
		
		//----------------------------------------
	// 1] PriorityQueue
		//represents queue where elements are ordered according to their natural ordering or a custom comparator
		//No fixed capacity- grows dynamically, initial capacity can be specified
		//Not thread safe- not synchronized
		//Does not allow Null as null is used in special return value indicating queue is empty
		//implemented using binary heap structure which allows efficient insertion and removal
		//No random access
		
		PriorityQueue<Integer> priorityQueue1=new PriorityQueue<>();
		
		System.out.println(priorityQueue1.add(10));
		System.out.println(priorityQueue1.add(20));
		System.out.println(priorityQueue1.offer(30));
		System.out.println(priorityQueue1.remove(20)); //deletes head returns exception if empty 
		System.out.println(priorityQueue1.poll()); //deleted head returns null if empty
		System.out.println(priorityQueue1.element()); //returns exception if empty
		System.out.println(priorityQueue1.peek()); //returns head without deleting else null
		System.out.println(priorityQueue1.contains(20)); //return true 
		System.out.println(priorityQueue1.remove(20)); //remove single first occured element
		System.out.println(priorityQueue1.size());
		priorityQueue1.clear();
		
		
		//-------------------------------------------
		// -Deque interface
		//implements queue interface
		//represent double ended queue
		//supports LIFO and FIFO both
		//allows adding and removing elements from both ends head and tail
		//no fixed capacity - (also support limited capacity where maximum capacity is set)
		//allow duplicates
		//null is not allowed
		//no thread safety
		//no random access
		
		//Deque Implements
			//1.ArrayDeque
			//2.LinkedList
		
		//-------------------------------------------
	// 2] LinkedList 
		//Implements both List and Deque interface
		//it is double linked list implementation that allows efficient insertion and deletion
		//Dynamic sizing
		//allow duplicates
		//Allows Null elements
		//Sequential access
		//no random access
		//Has nodes - every node has 3 parts 1.Data 2.reference to previous node 3.reference to next node
		
		LinkedList<Integer> linkedList=new LinkedList<>();
		System.out.println(linkedList.add(10));
		System.out.println(linkedList.add(20));
		System.out.println(linkedList.add(30));
		System.out.println(linkedList.add(40));
		System.out.println(linkedList.add(20));
		System.out.println(linkedList.offer(30));
		System.out.println(linkedList.remove()); //deletes head returns exception if empty 
		System.out.println(linkedList.poll()); //deleted head returns null if empty
		System.out.println(linkedList.element()); //returns exception if empty
		System.out.println(linkedList.peek()); //returns head without deleting else null
		System.out.println(linkedList.contains(20)); //return true 
		System.out.println(linkedList.remove()); //remove single first occurred element
		System.out.println(linkedList.size());
		//Deque operations
		linkedList.addFirst(40);
		linkedList.addLast(10);
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getLast());
		System.out.println(linkedList.removeFirst());
		System.out.println(linkedList.removeLast());
		System.out.println(linkedList.offerFirst(20)); //same as addFirst but returns true when added 
		System.out.println(linkedList.offerLast(10)); //same as addLast but returns true when added
		System.out.println(linkedList.poll()); //Retrieve and remove head and return null if empty
		System.out.println(linkedList.peek()); //Retrieve but doesn't remove and return null if empty
		//stack operations
		linkedList.push(10);
		System.out.println(linkedList.pop());
		//bulk operation
		System.out.println(linkedList.contains(10));
		linkedList.clear();
		
		//---------------------------------------------------
	// 3] ArrayDeque
		//Resizeable array based that provides efficient double ended queue for adding and removing elements from both ends
		//can be used as Stack(LIFO) or Queue(FIFO)
		//double ended queue
		//no fixed capacity
		//daster than LinkedList for stack and Queue operations
		//No Null elements
		//Non- threaded - not synchronized
		//ArrayDeque uses circular array to store elements , when element is added or removed at start or end positions of deque are adjusted to reflect changes. THis circular structure allows efficient adding and removing from both the ends without shifting elements
		
		ArrayDeque<Integer> arrayDeque1= new ArrayDeque<>();
		ArrayDeque<Integer> arrayDeque2= new ArrayDeque<>(10);
		ArrayDeque<Integer> arrayDeque3=new ArrayDeque<>(arrayDeque1);
		
		
		arrayDeque1.addFirst(40);
		arrayDeque1.addLast(10);
		System.out.println(arrayDeque1.getFirst());  //if not present gives exception
		System.out.println(arrayDeque1.getLast());
		System.out.println(arrayDeque1.removeFirst());
		System.out.println(arrayDeque1.removeLast());
		System.out.println(arrayDeque1.offerFirst(20)); //same as addFirst but returns true when added 
		System.out.println(arrayDeque1.offerLast(10)); //same as addLast but returns true when added
		System.out.println(arrayDeque1.pollFirst()); //Retrieve and remove head and return null if empty
		System.out.println(arrayDeque1.pollLast()); //Retrieve and remove head and return null if empty
		System.out.println(arrayDeque1.peekFirst()); //Retrieve but doesn't remove and return null if empty
		System.out.println(arrayDeque1.peekLast()); //Retrieve but doesn't remove and return null if empty
		//stack implementation on ArrayDeque
		arrayDeque1.push(60);
		System.out.println(arrayDeque1.peek());
		System.out.println(arrayDeque1.pop());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
