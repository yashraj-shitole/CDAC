package BinarySearchTree;

public class TestMain {

	public static void main(String[] args) {
	
		
		BinarySearchTree bst=new BinarySearchTree();
		
		bst.addNode(100);
		bst.addNode(50);
		bst.addNode(230);
		bst.addNode(54);
		bst.addNode(523);
		bst.addNode(223);
		bst.addNode(630);
		bst.addNode(40);
		bst.addNode(80);

		bst.preOrder();
		System.out.println();
		bst.inOrder();
		System.out.println();
		bst.postOrder();
		
		System.out.println();
		
		System.out.println(bst.search(54).toString());
		
		
	}

}
