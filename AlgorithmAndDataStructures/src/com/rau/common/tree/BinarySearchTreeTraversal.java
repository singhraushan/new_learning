package com.rau.common.tree;

import com.rau.common.tree.RootToLeafPrinting.Node;

public class BinarySearchTreeTraversal {

	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print(root.data + " ");
		preOrder(root.right);
	}

	public static void postOrder(Node root) {
		if (root == null)
			return;
		preOrder(root.left);
		preOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		Node root = new Node(44);
		root.left = new Node(17);
		root.right = new Node(78);
		root.left.right = new Node(32);

		root.right.left = new Node(50);
		root.right.right = new Node(88);

		root.right.left.left = new Node(48);
		root.right.left.right = new Node(62);
		
		System.out.print("preOrder: ");
		preOrder(root);
		System.out.println();

		System.out.print("inOrder: ");
		inOrder(root);
		System.out.println();

		System.out.print("postOrder: ");
		postOrder(root);

	}
}
