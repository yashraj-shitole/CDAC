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
	
	private int height(Node trav) {
		//1. if left or right subtree is absent return -1
		if(trav == null)
			return -1;
		//2. find height of left sub tree
		int hl = height(trav.left);
		//3. find height of right sub tree
		int hr = height(trav.right);
		//4. find max of both heights
		int max = hl < hr ? hr : hl;
		//5. return max height + 1
		return max + 1;
	}
	
	public int height() {
		return height(root);
	}
	
	public void deleteAll() {
		root = null;
	}
}













