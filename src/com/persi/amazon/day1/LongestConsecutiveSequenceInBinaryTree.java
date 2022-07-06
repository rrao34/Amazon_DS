package com.persi.amazon.day1;

import java.util.ArrayList;
import java.util.List;

public class LongestConsecutiveSequenceInBinaryTree {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}


	static class BinaryTree {
		Node root;
		List<Node> list = new ArrayList<>();

		// Utility method to return length of longest consecutive sequence of tree
		private List<Node> longestConsecutiveUtil(Node root, int curlength, int expected) {
			if (root == null)
				return new ArrayList<>();

			// if root data has one more than its parent then increase current length
			if (root.data == expected) {
				curlength++;
				list.add(root);
			} else {
				curlength = 1;
			}

			// recursively call left and right subtree with expected value 1 more than root
			// data
			longestConsecutiveUtil(root.left, curlength, root.data + 1);
			longestConsecutiveUtil(root.right, curlength, root.data + 1);
			
			return list;
		}

		void get(List<Node> head) {
			boolean isLeftNull = true;
			boolean isRightNull = true;
			if (head != null) {
				if (head.get(0).left == null) {
					isLeftNull = false;
				} else if (head.get(0).right == null) {
					isRightNull = false;
				}
			}
			Node node = head.get(0);
			while (true) {
				if (isLeftNull && node.left != null) {
					System.out.println(node.left.data);
					node = node.left;
				} else if (isRightNull && node.right != null) {
					System.out.println(node.right.data);
					node = node.right;
				}
			}
		}
	}

	// Driver code
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(6);
		tree.root.right = new Node(9);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(10);
		tree.root.right.right.right = new Node(11);

		tree.get(tree.longestConsecutiveUtil(tree.root, 0, tree.root.data));
	}
}
