package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class Graph {
	private int edgeCount, vertexCount;
	private boolean adjmat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new boolean[vertexCount][vertexCount];
	}
	
	public void accept(Scanner sc) {
		System.out.print("No of edges : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges : (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjmat[src][dest] = true;
			adjmat[dest][src] = true;			// comment this line for directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(adjmat[u][v] ? " " + 1 : " " + 0);
			}
			System.out.println();
		}
	}
	
	public void DFSTraversal(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create an array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose a start vertex --> start
		//2. push start vertexon stack and mark it
		st.push(start);
		marked[start] = true;
		System.out.print("DFS Traversal : ");
		//6. repeat untill stack is empty
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//4. print the vertex
			System.out.print(" " + u);
			//5. push all non marked adjacent vertices of u and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjmat[u][v]) {
					st.push(v);
					marked[v] = true;
				}
			}
		}
		System.out.println();
	}
	
	public void BFSTraversal(int start) {
		//0. create a queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex -- > start
		//2. push start vertex on queue and mark it
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS Traversal : ");
		//6. repeat until queue is empty
		while(!q.isEmpty()) {
			//3. pop from queue
			int u = q.poll();
			//4. print poped vertex
			System.out.print(" " + u);
			//5. push all non marked adjacent vertices on queue and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjmat[u][v]) {
					q.offer(v);
					marked[v] = true;
				}
			}
		}
		System.out.println();
 	}
	
	public void singleSourcePathLength(int start) {
		//0. create a queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//0. create array to maintain length of paths of all the vertices
		int length[] = new int[vertexCount];
		//1. choose start vertex -- > start
		//2. push start vertex on queue, mark it and make length = 0
		q.offer(start);
		marked[start] = true;
		length[start] = 0;
		System.out.print("Path Length Tree : ");
		//6. repeat until queue is empty
		while(!q.isEmpty()) {
			//3. pop from queue
			int u = q.poll();
			//5. push all non marked adjacent vertices on queue, mark them, update length and print edge
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjmat[u][v]) {
					q.offer(v);
					marked[v] = true;
					length[v] = length[u] + 1;
					System.out.print("(" + u + "," + v + ")");
				}
			}
		}
		System.out.println();
		//7. print length array
		for(int i = 0 ; i < vertexCount ; i++)
			System.out.println(start + "->" + i + "=" + length[i]);	
 	}
	
	public void DFSSpannigTree(int start) {
		//0. create stack to push vertices
		Stack<Integer> st = new Stack<Integer>();
		//0. create an array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose a start vertex --> start
		//2. push start vertexon stack and mark it
		st.push(start);
		marked[start] = true;
		System.out.print("DFS Traversal : ");
		//6. repeat untill stack is empty
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//5. push all non marked adjacent vertices of u and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjmat[u][v]) {
					st.push(v);
					marked[v] = true;
					System.out.print("(" + u + "," + v + ")");
					
				}
			}
		}
		System.out.println();
	}
	
	public void BFSSpannigTree(int start) {
		//0. create a queue to push vertices
		Queue<Integer> q = new LinkedList<Integer>();
		//0. create array to mark the vertices
		boolean marked[] = new boolean[vertexCount];
		//1. choose start vertex -- > start
		//2. push start vertex on queue and mark it
		q.offer(start);
		marked[start] = true;
		System.out.print("BFS Spannig tree : ");
		//6. repeat until queue is empty
		while(!q.isEmpty()) {
			//3. pop from queue
			int u = q.poll();
			//5. push all non marked adjacent vertices on queue and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjmat[u][v]) {
					q.offer(v);
					marked[v] = true;
					System.out.print("(" + u + "," + v + ")");
				}
			}
		}
		System.out.println();
 	}
}















