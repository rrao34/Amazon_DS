package com.persi.amazon.day1;

public class ReverseDoublyLinkedList {
	static class Node {
		int data;
		Node next, prev;
	}

	static class CustomDoublyLinkedList {

		/**
		 * This method will be used to add elements to the list
		 * 
		 * @param head
		 * @param data
		 * @return
		 */
		Node insert(Node head, int data) {
			Node new_node = new Node();
			new_node.data = data;
			new_node.next = null;
			Node temp = head;

			if (head == null) {
				new_node.prev = null;
				head = new_node;
				return head;
			}

			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_node;
			new_node.prev = temp;
			return head;
		}

		/**
		 * This method will be used to get the elements from the list
		 * 
		 * @param head
		 */
		void get(Node head) {
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
			System.out.println();
		}

		/**
		 * It will reverse the list based on the given number as 'k'
		 * 
		 * @param head
		 * @param numberToReverse
		 * @return
		 */
		Node reverseByN(Node head, int numberToReverse) {
			if (head == null)
				return null;

			head.prev = null;
			Node temp;
			Node curr = head;
			Node newHead = null;
			int count = 0;

			while (curr != null && count < numberToReverse) {
				newHead = curr;
				temp = curr.prev;
				curr.prev = curr.next;
				curr.next = temp;
				curr = curr.prev;
				count++;
			}

			if (count >= numberToReverse) {
				Node rest = reverseByN(curr, numberToReverse);
				head.next = rest;
				if (rest != null)
					rest.prev = head;
			}
			return newHead;
		}
	}

	public static void main(String args[]) {
		CustomDoublyLinkedList list = new CustomDoublyLinkedList();
		Node head = null;
		for (int i = 1; i <= 10; i++) {
			head = list.insert(head, i);
		}

		list.get(head);
		int numberToReverse = 3;

		head = list.reverseByN(head, numberToReverse);
		list.get(head);
	}
}
