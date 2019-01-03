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
	/* Given a binary tree, print its nodes according to the 
    "bottom-up" postorder traversal. */
  void postorder(BSTNode node) 
  { 
      if (node == null) 
          return; 

      // first recur on left subtree 
      postorder(node.left); 

      // then recur on right subtree 
      postorder(node.right); 

      // now deal with the node 
      System.out.print(node.value + " "); 
  } 

  /* Given a binary tree, print its nodes in inorder*/
  void inorder(BSTNode node) 
  { 
      if (node == null) 
          return; 

      /* first recur on left child */
      inorder(node.left); 

      /* then print the data of node */
      System.out.print(node.value + " "); 

      /* now recur on right child */
      inorder(node.right); 
  } 

  /* Given a binary tree, print its nodes in preorder*/
  void preorder(BSTNode node) 
  { 
      if (node == null) 
          return; 

      /* first print data of node */
      System.out.print(node.value + " "); 

      /* then recur on left sutree */
      preorder(node.left); 

      /* now recur on right subtree */
      preorder(node.right); 
  } 
  
	public static void main(String[] args) {
		BinarySearchTree bstree = new BinarySearchTree();
		// bstree.insert(10);
		// bstree.insert(5);
		// bstree.insert(30);
		bstree.add(10);
		bstree.add(5);
		bstree.add(30);
		bstree.test(1, 2);
		int a1=1,a2=2;
		bstree.test(a1, a2);
	}
	
	 void test(int a1,int a2) 
	  { 
		 System.out.println("primitive");
	  } 

	 void test(Integer a1,Integer a2) 
	  { 
		 System.out.println("Non-primitive");
	  } 
}

class BSTNode {
	BSTNode left, right;
	int value;

	BSTNode(int value) {
		this.value = value;
	}
}
