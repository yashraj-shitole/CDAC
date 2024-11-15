package PuneDSAExam;


//Write a program to generate a Binary Search tree which is initially empty with key values 3.2, 1.5, 6.3, 9.8, 2.1, 5.7, 4.5, 7.4, 1.0. Show
//following options to the user and as per user choice perform the operations on BST continuously.
//1. Print all leaf nodes in BST 
//2. Print all non leaf nodes in BST
//3. Print count of all full nodes in BST
//4. Print parent of user entered node in BST
//5. Print childrens of user entered node in BST
//6. Print all pairs of siblings in BST


public class PuneDSAEXAM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree bst=new BinarySearchTree();
		
		bst.addNode(3.6);
		bst.addNode(1.5);
		bst.addNode(6.3);
		bst.addNode(9.8);
		bst.addNode(2.1);
		bst.addNode(5.7);
		bst.addNode(4.5);
		bst.addNode(7.4);
		bst.addNode(1.0);
		
//		bst.inOrder(bst.root);
//		System.out.println();
//		bst.postOrder(bst.root);
//		System.out.println();
		bst.leafNodes(bst.root);
		System.out.println();
		bst.nonLeafNodes(bst.root);
		System.out.println();
		
		bst.fullNodes(bst.root);
		System.out.println(bst.count);
		System.out.println();

	}

}


class BinarySearchTree {
	
	class Node{
		Node left,right;
		double data;
		
		public Node(double data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	
	Node root=null;
	
	public void addNode(double data) {
		root=addNode(root,data);
		}
	
	
	private Node addNode(Node trav, double data) {
		if(trav==null) {
			return new Node(data);
		}
		
			if(data<trav.data) {
				trav.left=addNode(trav.left, data);
			}
			else if(data>=trav.data) {
				trav.right=addNode(trav.right, data);
			}
		
		
		
		return trav;
	}
	
	public void postOrder(Node root) {
		
		if(root==null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		
		System.out.println(root.data);
		
	}
	
	
	//prints leafNodes
	public void leafNodes(Node root) {
		
		if(root==null) {
			return;
		}
		
		leafNodes(root.left);
		leafNodes(root.right);
		
		if(root.left==null && root.right==null) {
		System.out.println(root.data);
		}
		
	}
	
	//counts all full nodes
	int count=0;
	public void fullNodes(Node root) {
		
		if(root==null) {
			return;
		}
		
		fullNodes(root.left);
		fullNodes(root.right);
		
		if(root.left!=null && root.right!=null) {
		count++;
		}
		
	}
	
	//print non leaf nodes
	public void nonLeafNodes(Node root) {
		
		if(root==null) {
			return;
		}
		
		nonLeafNodes(root.left);
		nonLeafNodes(root.right);
		
		if(root.left!=null || root.right!=null) {
		System.out.println(root.data);
		}
		
	}
	
	


	public void giveParentChild(double data) {
		
	}
	
	public void deleteNode() {
		
	}
	
	
	public void inOrder(Node trav) {
		if(trav==null) {
			return;
		}
		inOrder(trav.left);
		System.out.println(trav.data);
		inOrder(trav.right);
		
		
	}
	
	
}