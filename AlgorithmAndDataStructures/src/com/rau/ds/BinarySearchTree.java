package com.rau.ds;

/**
 * @author Raushan kumar
 *
 */
public class BinarySearchTree {
	BSTNode root;

	public void insert(int value) {
		if (root == null) {
			root = new BSTNode(value);
			return;
		} else
			insert(root, value);
	}

	public void insert(BSTNode root, int value) {// using recursion
		if (value < root.value) {
			if (root.left == null) {
				root.left = new BSTNode(value);
				return;
			} else
				insert(root.left, value);
		} else {
			if (root.right == null) {
				root.right = new BSTNode(value);
				return;
			} else
				insert(root.right, value);
		}
	}

	public void add(int value) {// using loop
		if (root == null) {
			root = new BSTNode(value);
			return;
		} else {
			BSTNode currNode = root;
			while (currNode != null) {
				if (value < currNode.value) {
					if (currNode.left == null) {
						currNode.left = new BSTNode(value);
						return;
					} else
						currNode = currNode.left;
				} else {
					if (currNode.right == null) {
						currNode.right = new BSTNode(value);
						return;
					} else
						currNode = currNode.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bstree = new BinarySearchTree();
		// bstree.insert(10);
		// bstree.insert(5);
		// bstree.insert(30);
		bstree.add(10);
		bstree.add(5);
		bstree.add(30);

	}
}

class BSTNode {
	BSTNode left, right;
	int value;

	BSTNode(int value) {
		this.value = value;
	}
}
