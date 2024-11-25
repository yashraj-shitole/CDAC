package BinarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree {
	
	class Node{
		Node left,right;
		int data;
		
		public Node(int data) {
			this.data=data;
		}

		@Override
		public String toString() {
			return "\t" + left +"\t" + data + "\t" + right + "\t";
		}
		
		
		
	}
	
	Node root;
	
	
	public void addNode(int value) {
		Node newnode = new Node(value);
		if(root == null)
			root = newnode;
		else {
			Node trav = root;
			while(true) {
				if(value < trav.data) {
					if(trav.left == null) {
						trav.left = newnode;
						break;
					}else
						trav = trav.left;
				}else {
					if(trav.right == null) {
						trav.right = newnode;
						break;
					}else
						trav = trav.right;
				}
			}
		}
	}
	
	
	public Node[] findParent(int key) {
		
		Node trav=root;
		Node parent=null;
		
		while(trav!=null) {	
			if(trav.data==key) {
				break;
			}
			parent=trav;
			
			if(trav.data>key) {
				trav=trav.left;
			}
			else {
				trav=trav.right;
			}
		}
		if(trav==null) {
			parent=null;
		}
		return new Node[] {parent,trav};
	}
	
	
	
	public void deleteNode(int key) {
		Node arr[] = findParent(key);
		Node temp = arr[0], parent = arr[1];
		if(temp == null)
			return;
		if(temp.left != null && temp.right != null){
			Node pred = temp.left;
			parent = temp;
			while(pred.right != null){
				parent = pred;
				pred = pred.right;
			}
			temp.data = pred.data;
			temp = pred;
		}
		if(temp.left == null){
			if(temp == root)
				root = temp.right;
			else if(temp == parent.left)
				parent.left = temp.right;
			else if(temp == parent.right) 
				parent.right = temp.right;
		}
		else {
			if(temp == root)
				root = temp.left;
			else if(temp == parent.left)
				parent.left = temp.left;
			else if(temp == parent.right)
				parent.right = temp.left;
		}
	}
	
	
	
	

	public Node buildTreeFromList(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(alist.get(mid));
        node.left = buildTreeFromList(list, start, mid - 1);
        node.right = buildTreeFromList(list, mid + 1, end);
        return node;
    }
	
	
	ArrayList<Integer> alist=new ArrayList<>();
	
	
	public void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		alist.add(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		alist.add(root.data);
		inOrder(root.right);
	}

	public void postOrder(Node root) {
		if(root==null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
		
	}
}
