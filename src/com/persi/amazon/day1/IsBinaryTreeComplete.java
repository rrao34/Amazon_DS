package com.persi.amazon.day1;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsBinaryTreeComplete {

	/**
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 * 
	 * @author Rohit Rao
	 *
	 */
	static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
	};

	/**
	 * Given a binary tree, return true if the tree is complete else false
	 * 
	 * @param root
	 * @return
	 */
	static boolean isCompleteBT(Node root) {

		 // return if the tree is empty
        if (root == null) {
            return true;
        }
 
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // to store the current node
        Node front;
 
        // flag to mark the end of full nodes
        boolean isComplete = false;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // dequeue front node
            front = queue.poll();
 
            /*// if we have encountered a non-full node before and the current node
            // is not a leaf, a tree cannot be complete
            if (isComplete && (front.left != null || front.right != null)) {
                return true;
            }*/
 
            // if the left child is empty and the right child exists,
            // a tree cannot be complete
            if ((front.left != null && front.right == null)
            		|| (front.left == null && front.right != null)) {
            	isComplete = false;
            	return isComplete;
            }
 
            // if the left child exists, enqueue it
            if (front.left != null) {
                queue.add(front.left);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                isComplete = true;
            }
 
            // if the right child exists, enqueue it
            if (front.right != null) {
                queue.add(front.right);
            }
            // if the current node is a non-full node, set the flag to true
            else {
                isComplete = true;
            }
        }
 
        return isComplete;
	}


	public static void main(String[] args) {
		/* Let us construct the following Binary Tree which
        is not a complete Binary Tree
             1
            / \
            2   3
           / \  /
          4   5 6
        */

		Node root = new Node(1);
		root.left =  new Node(2);
		root.right =  new Node(3);
		root.left.left =  new Node(4);
		root.left.right =  new Node(5);
		root.right.left =  new Node(6);
		//root.right.right =  new Node(7);
		

		if (isCompleteBT(root) == true)
			System.out.print("Complete Binary Tree");
		else
			System.out.print("Not Complete Binary Tree");

	}
}
