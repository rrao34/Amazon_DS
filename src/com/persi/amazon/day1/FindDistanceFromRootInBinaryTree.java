package com.persi.amazon.day1;

public class FindDistanceFromRootInBinaryTree {
	static class Node {
		int data;
		Node left, right;
	}

	// A utility function to create a new Binary Tree Node
	static Node newNode(int item) {
		Node temp = new Node();
		temp.data = item;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	// Returns -1 if x doesn't exist in tree. Else returns distance of x from root
	static int findDistance(Node root, int value) {
		if (root == null)
			return -1;

		int dist = -1;

		// Check if x is present at root or in left subtree or right subtree.
		if ((root.data == value) 
				|| (dist = findDistance(root.left, value)) >= 0 
				|| (dist = findDistance(root.right, value)) >= 0) {
			return dist + 1;
		}
			
		return dist;
	}

	public static void main(String[] args) {
		Node root = newNode(5);
		root.left = newNode(10);
		root.right = newNode(15);
		root.left.left = newNode(20);
		root.left.right = newNode(25);
		root.left.right.right = newNode(45);
		root.right.left = newNode(30);
		root.right.right = newNode(35);
		root.right.right.right = newNode(40);
		root.right.right.right.right = newNode(55);

		System.out.println(findDistance(root, 55));
	}
}
