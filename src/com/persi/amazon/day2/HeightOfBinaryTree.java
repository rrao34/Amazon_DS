package com.persi.amazon.day2;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right;
		}
	}

	static class BinaryTree {
		Node root;

		// Iterative method to find height of Binary Tree
		int treeHeight(Node node) {
			// Base Case
			if (node == null)
				return 0;

			// Create an empty queue for level order traversal
			Queue<Node> queue = new LinkedList<>();

			// Enqueue Root and initialize height
			queue.add(node);
			int height = 0;

			while (true) {
				// nodeCount (queue size) indicates number of nodes
				// at current level.
				int nodeCount = queue.size();
				if (nodeCount == 0) {
					return height;
				}

				height++;

				// Dequeue all nodes of current level and Enqueue all
				// nodes of next level
				while (nodeCount > 0) {
					Node newnode = queue.peek();
					queue.remove();
					if (newnode.left != null) {
						queue.add(newnode.left);
					} else if (newnode.right != null) {
						queue.add(newnode.right);
					}

					nodeCount--;
				}
			}
		}
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		// Let us create a binary tree shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(7);
		System.out.println("Height of tree is " + tree.treeHeight(tree.root));
	}
}
