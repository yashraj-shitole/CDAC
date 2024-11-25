package BinarySearchTree;

public class BinarySearchTree {

	class Node{
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
	

	/*
	 * addNode()
	 * delete()
	 * search() - preorder() inorder() postorder()
	 * traverse()
	 * 
	 */
	
	//1. create node for given value
	//2. if BSTree is empty
		// add newnode into root itself
	//3. if BSTree is not empty
		//3.1 create trav reference and start at root node
		//3.2 if value is less than current node data (trav.data)
		//3.2.1 if left of current node is empty
			// add newnode into left of current node
		//3.2.2 if left of current node is not empty
			// go into left of current node
		//3.3 if value is greater or equal than current node data (trav.data)
		//3.3.1 if right of current node is empty
			// add newnode into right of current node
		//3.3.2 if right of current node is not empty
			// go into right of current node
		//3.4 repeat step 3.2 and 3.3 till node is not getting added into BSTree
	


	public void addNode(int data) {
		Node newNode=new Node(data);
		if(root==null) {
			root=newNode;
		}else {
			Node current=root;
			
			while(true) {
				if(current.data>data) {
					if(current.left==null) {
						current.left=newNode;
						break;
					}else {
						current=current.left;
					}
				}else if(current.data<=data){
					if(current.right==null) {
						current.right=newNode;
						break;
					}
					else {
						current=current.right;
					}
				}
			}
		}
	}
	
	
	
	
	public void preOrder(Node trav) {
		
		if(trav==null) {
			return;
		}
		System.out.print(" "+trav.data);
		preOrder(trav.left);
		preOrder(trav.right);	
	}
	
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void inOrder(Node trav ) {
		
		if(trav==null) {
			return;
		}
		
		inOrder(trav.left);
		System.out.print(" "+trav.data);
		inOrder(trav.right);
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	public void postOrder(Node trav) {
		
		if(trav==null) {
			return;
		}
		
		System.out.print(" "+trav.data);
		postOrder(trav.left);
		postOrder(trav.right);
	}
	public void postOrder() {
		postOrder(root);
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
	
	
	public Node search(int data) {
		Node trav=root;
		
		while(trav!=null) {
			
			if(data==trav.data) {
				return trav;
			}
			else if(data<trav.data) {
				trav=trav.left;
			}
			else {
				trav=trav.right;
			}
		}
		
		return null;
				
	}

}
