package com.rau.common.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.rau.common.tree.RootToLeafPrinting.Node;

public class BFSForBinaryTree {

	static class Node {
		Node left, right;
		Object data;

		Node(Object data) {
			this.data = data;
		}
	}

	public static void printLevelByLevel(Node root) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);// adding
		System.out.println(q.element().data);// after adding print. //1st level
												// i.e. root node

		while (!q.isEmpty()) {
			int size = q.size();
			String levelValues = "";
			
			for (int level = 0; level < size; level++) {
				Node n = q.poll();// after printing remove
				if (n.left != null) {
					q.add(n.left);
					levelValues += n.left.data;
				}
				if (n.right != null){
					q.add(n.right);
				levelValues += n.right.data;
				}
			}
			
			System.out.println(levelValues);
			levelValues = "";
		}
		
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printLevelByLevel(root);
	}
}
