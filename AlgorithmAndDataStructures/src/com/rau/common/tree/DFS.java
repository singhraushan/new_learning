package com.rau.common.tree;

import java.util.LinkedList;

import com.rau.common.tree.BFSForBinaryTree.Node;

public class DFS {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printVerticallyRecursively(root, new LinkedList<Integer>());

	}

	public static void printVerticallyRecursively(Node root, LinkedList<Integer> list) {

		if (root == null)
			return;

		list.add((Integer) root.data);
		if (isLeafNode(root)) {
			System.out.println(list);
		}
		printVerticallyRecursively(root.left, new LinkedList<>(list));

		printVerticallyRecursively(root.right, new LinkedList<>(list));

	}

	public static boolean isLeafNode(Node node) {
		return (node.left == null && node.right == null);
	}
}
