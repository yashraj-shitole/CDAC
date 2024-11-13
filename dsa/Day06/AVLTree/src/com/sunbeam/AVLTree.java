package com.sunbeam;

public class AVLTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;
		private int height;
		public Node() {
			data = 0;
			left = null;
			right = null;
			height = 0;
		}
		public Node(int val) {
			data = val;
			left = null;
			right = null;
			height = 0;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getHeight() {
			return height;
		}
		public int getLeftHeight() {
			return left==null ? 0 : left.height;
		}
		public int getRightHeight() {
			return right==null ? 0 : right.height;
		}
		public int getBF() {
			return getLeftHeight() - getRightHeight();
		}
	}
	
	private Node root;

	public AVLTree() {
		root = null;
	}
	
	public void add(Node parent, Node trav, int val) {
		if(val < trav.getData()) {
			if(trav.left != null) 
				add(trav, trav.left, val);
			else
				trav.left = new Node(val);
		}
		else {
			if(trav.right != null)
				add(trav, trav.right, val);
			else
				trav.right = new Node(val);
		}
		
		// adjust height of node.
		trav.height = Integer.max(trav.getLeftHeight(), trav.getRightHeight()) + 1;
		int bf = trav.getBF();
		// left-left case
		if(bf > 1 && val < trav.left.data)
		{
			//cout << "LL " << trav->data << endl;
			rightRotate(parent, trav);
			return;
		}
		// right-right case
		if(bf < -1 && val > trav.right.data)
		{
			//cout << "RR " << trav->data << endl;
			leftRotate(parent, trav);
			return;
		}
		// left-right case
		if(bf > 1 && val > trav.left.data)
		{
			//cout << "LR " << trav->data << endl;
			leftRotate(trav, trav.left);
			rightRotate(parent, trav);
			return;
		}
		// right-left case
		if(bf < -1 && val < trav.right.data)
		{
			//cout << "RL " << trav->data << endl;
			rightRotate(trav, trav.right);
			leftRotate(parent, trav);
			return;
		}
	}
	
	public void add(int val) {
		if(root == null)
			root = new Node(val);
		else
			add(null, root, val);
	}

	public Node leftRotate(Node parent, Node axis) {
		if(axis==null || axis.right==null)
			return null;
		Node newaxis = axis.right;
		axis.right = newaxis.left;
		newaxis.left = axis;
		if(axis==root)
			root = newaxis;
		else if(axis==parent.left)
			parent.left = newaxis;
		else
			parent.right = newaxis;
		axis.height = Integer.max(axis.getLeftHeight(), axis.getRightHeight())+1;
		newaxis.height = Integer.max(newaxis.getLeftHeight(), newaxis.getRightHeight())+1;
		return newaxis;
	}
	
	public Node rightRotate(Node parent, Node axis) {
		if(axis==null || axis.left==null)
			return null;
		Node newaxis = axis.left;
		axis.left = newaxis.right;
		newaxis.right = axis;
		if(axis==root)
			root = newaxis;
		else if(axis==parent.left)
			parent.left = newaxis;
		else
			parent.right = newaxis;
		axis.height = Integer.max(axis.getLeftHeight(), axis.getRightHeight())+1;
		newaxis.height = Integer.max(newaxis.getLeftHeight(), newaxis.getRightHeight())+1;
		return newaxis;
	}

	public int height() {
		//return root == null ? -1 : root.height();
		return height(root);
	}
	public int height(Node trav) {
		if(trav == null)
			return -1;
		int leftHeight = height(trav.left);
		int rightHeight = height(trav.right);
		return Integer.max(leftHeight, rightHeight) + 1;
	}

	public void preorder(Node trav) {
		if(trav == null)
			return;
		System.out.print(trav.data + ", ");
		preorder(trav.left);
		preorder(trav.right);
	}
	public void preorder() {
		System.out.print("PRE : ");
		preorder(root);
		System.out.println();
	}

}
