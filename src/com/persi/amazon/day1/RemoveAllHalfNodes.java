package com.persi.amazon.day1;

public class RemoveAllHalfNodes {
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

		void printInorder(Node node) {
			if (node != null) {
				printInorder(node.left);
				System.out.print(node.data + " ");
				printInorder(node.right);
			}
		}

		// Removes all nodes with only one child and returns
		// new root (note that root may change)
		Node RemoveHalfNodes(Node node) {
			if (node == null)
				return null;

			node.left = RemoveHalfNodes(node.left);
			node.right = RemoveHalfNodes(node.right);

			/* if current node is a leaf node then return it without modifying it */
			if (node.left == null && node.right == null)
				return node;

			/*
			 * if current nodes is a half node with left child NULL left, then it's right
			 * child is returned and replaces it in the given tree
			 */
			if (node.left == null) {
				return node.right;
			}

			/*
			 * if current nodes is a half node with right child NULL right, then it's left
			 * child is returned and replaces it in the given tree
			 */
			if (node.right == null) {
				return node.left;
			}

			return node;
		}
	}
	
	
	/*			2
			 /		\
			7		 5
			\		  \
			6 		   9
			/\  	  /
		   1  11	 4
*/
	// Driver program
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node NewRoot = null;
		tree.root = new Node(2);
		tree.root.left = new Node(7);
		tree.root.right = new Node(5);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(1);
		tree.root.left.right.right = new Node(11);
		tree.root.right.right = new Node(9);
		tree.root.right.right.left = new Node(4);

		System.out.println("the inorder traversal of tree is ");
		tree.printInorder(tree.root);

		NewRoot = tree.RemoveHalfNodes(tree.root);

		System.out.print("\nInorder traversal of the modified tree \n");
		tree.printInorder(NewRoot);
	}
}
