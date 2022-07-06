package com.persi.amazon.day2;

import java.util.HashSet;

public class RemoveDuplicatesFromLinkedList {
	static class node {
		int data;
		node next;

		public node(int val) {
			this.data = val;
		}
	}

	/*
	 * Function to remove duplicates from a unsorted linked list
	 */
	static void removeDuplicate(node head) {
		// Hash to store seen values
		HashSet<Integer> hasSet = new HashSet<>();

		/* Pick elements one by one */
		node current = head;
		node prev = null;
		while (current != null) {
			int curVal = current.data;

			// If current value is seen before
			if (hasSet.contains(curVal)) {
				prev.next = current.next;
			} else {
				hasSet.add(curVal);
				prev = current;
			}
			current = current.next;
		}
	}

	/* Function to print nodes in a given linked list */
	static void printList(node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		/*
		 * The constructed linked list is: 10->12->11->11->12->11->10
		 */
		node head = new node(10);
		head.next = new node(12);
		head.next.next = new node(11);
		head.next.next.next = new node(11);
		head.next.next.next.next = new node(12);
		head.next.next.next.next.next = new node(11);
		head.next.next.next.next.next.next = new node(10);

		System.out.println("Linked list before removing duplicates :");
		printList(head);

		removeDuplicate(head);

		System.out.println("\nLinked list after removing duplicates :");
		printList(head);
	}
}
