package com.rau.common.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RootToLeafPrinting {

	static class Node {
		Node left, right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public static void printRootToLeaf(Node root) {
		printRootToLeaf(root, new ArrayList<Integer>());
	}

	public static boolean isLeafNode(Node node) {
		return (node.left == null && node.right == null);
	}

	public static void printRootToLeaf(Node root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.data);
		if (isLeafNode(root)) {
			System.out.println("root leaf node: " + list);
		}
		printRootToLeaf(root.left, new ArrayList(list));
		printRootToLeaf(root.right, new ArrayList(list));
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		 printRootToLeaf(root);
	}

}
