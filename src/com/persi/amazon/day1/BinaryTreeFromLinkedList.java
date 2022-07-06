package com.persi.amazon.day1;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeFromLinkedList {

	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	// A Linked List Node
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static class BinaryTree {
		// Utility function to create a new node with the given data and pushes it onto
		// the list's front
		public Node push(Node head, int data) {
			Node node = new Node(data);
			node.next = head;
			return node;
		}

		// Function to perform preorder traversal on a given binary tree.
		public void preOrder(TreeNode root) {
			if (root == null) {
				return;
			}

			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

		// Function to construct a complete binary tree from a given linked list
		public TreeNode convertListToBinaryTree(Node head) {
			if (head == null) {
				return null;
			}

			// create the root using the first node of the linked list
			TreeNode root = new TreeNode(head.data);

			// move the head pointer to the next node
			head = head.next;

			// create a queue to store tree pointers and enqueue the root node
			Queue<TreeNode> queue = new ArrayDeque<>();
			queue.add(root);

			// loop till the end of the linked list is reached
			while (head != null) {
				// dequeue front node
				TreeNode front = queue.poll();

				// create a left child from the next node in the linked list and enqueue it
				front.left = new TreeNode(head.data);
				queue.add(front.left);

				// move the head pointer to the next node
				head = head.next;

				// if the linked list did not reach its end
				if (head != null) {
					// create the right child from the next node in the linked list and
					// enqueue it
					front.right = new TreeNode(head.data);
					queue.add(front.right);

					// move the head pointer to the next node
					head = head.next;
				}
			}

			// return root of the constructed binary tree
			return root;
		}
	}

	public static void main(String[] args) {
		Node head = null;
		BinaryTree bt = new BinaryTree();

		// construct a linked list
		head = bt.push(head, 36);
		head = bt.push(head, 30);
		head = bt.push(head, 25);
		head = bt.push(head, 15);
		head = bt.push(head, 12);
		head = bt.push(head, 10);

		TreeNode root = bt.convertListToBinaryTree(head);
		bt.preOrder(root);
	}
}
