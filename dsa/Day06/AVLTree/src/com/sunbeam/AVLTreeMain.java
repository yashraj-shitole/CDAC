package com.sunbeam;

public class AVLTreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree t = new AVLTree();
		t.add(7);
		t.add(6);
		t.add(5);
		t.add(4);
		t.add(3);
		t.add(2);
		t.add(1);
		t.preorder();
		int height = t.height();
		System.out.println("Height: " + height);
	}

}
