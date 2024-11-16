package BinarySearchTree;

public class TestMain {

	public static void main(String[] args) {
		
		
		BinarySearchTree bst=new BinarySearchTree();
		
		bst.addNode(40);
		bst.addNode(10);
		bst.addNode(33);
		bst.addNode(57);
		bst.addNode(100);
		bst.addNode(72);
		bst.addNode(11);
		bst.addNode(86);
		bst.addNode(55);
		bst.addNode(12);
		bst.addNode(50);
		
		bst.inOrder(bst.root);
		System.out.println();
//		bst.postOrder(bst.root);
//		System.out.println();
		bst.deleteNode(33);
		System.out.println();
		bst.inOrder(bst.root);
//System.out.println();
//		bst.postOrder(bst.root);
		
		System.out.println(bst.root);
	}

}
