package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	static class Node{
		private int data;
		private Node left, right;
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}
	
	private Node root;
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create node
		Node newnode = new Node(value);
		//2. if BST is empty
		if(root == null)
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1 create trav and start at root
			Node trav = root;
			while(true) {
				//3.2 compare value with current node data
				if(value < trav.data) {
					//3.2.1 if value is less than current node data
					// if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}else // if left of current node is not empty
						// go into left of current node
						trav = trav.left;
				}else {
					//3.2.2 if value is greater or equal to current node data
					// if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}else// if right of current node is not empty
						// go into right of current node
						trav = trav.right;
				}
			}//3.3 repeat step 3.2 untill node is added in BST
		}
	}
	
	private void preOrder(Node trav) {
		//1. stop if left or right sub tree is absent
		if(trav == null)
			return;
		//2. print / visit current node
		System.out.print(" " + trav.data);
		//3. go in left current node
		preOrder(trav.left);
		//4. go in right of current node
		preOrder(trav.right);
	}
	
	public void preOrder() {
		System.out.print("Preorder : ");	
		preOrder(root);
		System.out.println();
	}
	
	private void inOrder(Node trav) {
		//1. stop if left or right sub tree is absent
		if(trav == null)
			return;
		//3. go in left current node
		inOrder(trav.left);
		//2. print / visit current node
		System.out.print(" " + trav.data);
		//4. go in right of current node
		inOrder(trav.right);
	}
	
	public void inOrder() {
		System.out.print("Inorder : ");	
		inOrder(root);
		System.out.println();
	}
	
	private void postOrder(Node trav) {
		//1. stop if left or right sub tree is absent
		if(trav == null)
			return;
		//3. go in left current node
		postOrder(trav.left);
		//4. go in right of current node
		postOrder(trav.right);
		//2. print / visit current node
		System.out.print(" " + trav.data);
	}
	
	public void postOrder() {
		System.out.print("Postorder : ");	
		postOrder(root);
		System.out.println();
	}
	
	public void DFSTraversal() {
		//0. create stack to push Nodes
		Stack<Node> st = new Stack<BST.Node>();
		//1. push root on stack
		st.push(root);
		System.out.print("DFS Traversal : ");
		while(!st.isEmpty()) {
			//2. pop Node from stack
			Node trav = st.pop();
			//3. visit/print poped node
			System.out.print(" " + trav.data);
			//4. if trav has right, push it on stack
			if(trav.right != null)
				st.push(trav.right);
			//5. if trav has left, push it on stack
			if(trav.left != null)
				st.push(trav.left);
		}//repeat till stack is not empty
		System.out.println();
	}
	
	public void BFSTraversal() {
		//0. create a queue to push Nodes
		Queue<Node> q = new LinkedList<BST.Node>();
		//1. push root on queue
		q.offer(root);			// push
		System.out.print("BFS Traversal : ");
		while(!q.isEmpty()) {
			//2. pop Node from queue
			Node trav = q.poll();		// pop
			//3. visit/ print trav's data
			System.out.print(" " + trav.data);
			//4. if left exists, push it on queue
			if(trav.left != null)
				q.offer(trav.left);
			//5. if right exists, pish it on queue
			if(trav.right != null)
				q.offer(trav.right);
		}// repeat till queue is not empty
		System.out.println();
	}
	
	public Node binarySearch(int key) {
		//1. start from root
		Node trav = root;
		while(trav != null) {
			//2. if key is equal to current node data then return current node address
			if(key == trav.data)
				return trav;
			//3. if key is less than current node data then serach key into left sub tree
			else if(key < trav.data)
				trav = trav.left;
			//4. if key is greater or equal than current node data then serach key into right sub tree
			else
				trav = trav.right;
		}//5. repeat above 3 steps till key is not found
		//6. if key is not found then return null
		return null;
	}
	
	public Node[] binarySearchWithParent(int key) {
		//1. start from root
		Node trav = root;
		Node parent = null;
		while(trav != null) {
			//2. if key is equal to current node data then return current node address
			if(key == trav.data)
				break;
			parent = trav;
			//3. if key is less than current node data then serach key into left sub tree
			if(key < trav.data)
				trav = trav.left;
			//4. if key is greater or equal than current node data then serach key into right sub tree
			else
				trav = trav.right;
		}//5. repeat above 3 steps till key is not found
		//6. if key is not found
		if(trav == null)
			parent = null;
		return new Node[]{trav, parent};
	}
	
	public void deleteNode(int key) {
		//1. search node for given key along with its parent
		Node arr[] = binarySearchWithParent(key);
		Node temp = arr[0], parent = arr[1];
		//2. if key is not found
		if(temp == null)
			return;
		//3. if node has 2 childs
		if(temp.left != null && temp.right != null){
			//1. find predecessor of temp.data
			Node pred = temp.left;
			parent = temp;
			while(pred.right != null){
				parent = pred;
				pred = pred.right;
			}
			//2. replace temp's data by predecessor's data
			temp.data = pred.data;
			//3. delete predecessor
			temp = pred;
		}
		//4. if node has single child (right child)
		if(temp.left == null){
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp.right;
			else if(temp == parent.right)
				parent.right = temp.right;
		}
		//5. if node has single child (left child)		
		else {//if(temp.right == null){
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else if(temp == parent.right)
				parent.right = temp.left;
		}
	}
	
	
	
	public void deleteAll() {
		root = null;
	}
}













