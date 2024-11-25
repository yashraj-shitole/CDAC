package Assignment05_Question01;
//1. Write recursive function to add node into bst.

public class Assignment05_Question01 {

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.add(100);
		bst.add(50);
		bst.add(230);
		bst.add(54);
		bst.add(523);
		bst.add(223);
		bst.add(630);
		bst.add(40);
		bst.add(80);

		bst.preOrder();
	}

}

class BinarySearchTree {

	class Node {

		Node left;
		int data;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node root;

	public void add(int data) {
		add(root, data);
	}

	public void add(Node trav, int data) {

		if (root == null) {
			root = new Node(data);
			return;
		}
		if (root != null) {
			if (trav.data > data) {
				if (trav.left == null) {
					trav.left = new Node(data);
					return;
				} else {
					add(trav.left, data);
				}
			} else if (trav.data <= data) {
				if (trav.right == null) {
					trav.right = new Node(data);
					return;
				} else {
					add(trav.right, data);
				}
			}

		}

	}

	public void preOrder(Node trav) {

		if (trav == null) {
			return;
		}
		System.out.print(" " + trav.data);
		preOrder(trav.left);
		preOrder(trav.right);
	}

	public void preOrder() {
		preOrder(root);
	}

}
