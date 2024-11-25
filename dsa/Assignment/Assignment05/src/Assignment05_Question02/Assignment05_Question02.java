package Assignment05_Question02;

//2. Write recursive function to perfrom search operation in bst.

public class Assignment05_Question02 {

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

		System.out.println();

		bst.preOrder();

		System.out.println();

		System.out.println(bst.search(50));
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

		@Override
		public String toString() {
			return "Node [left=" + left + ", data=" + data + ", right=" + right + "]";
		}

	}

	private Node root;

	public boolean search(int key) {
		return search(root, key);
	}

	public boolean search(Node trav, int key) {
		if (trav == null) {
			return false;
		}
		if (trav.data == key) {
			return true;
		} else {
			return search(trav.left, key) || search(trav.right, key);
		}

//		if (root != null) {
//
//			if (key == trav.data) {
//				System.out.println("Reached");
//				return true;
//			} else if (key < trav.data) {
//				search(trav.left, key);
//			} else {
//				search(trav.right, key);
//			}
//		}
//
//		return false;

	}

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
