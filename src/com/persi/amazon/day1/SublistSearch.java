package com.persi.amazon.day1;

import java.util.LinkedList;
import java.util.List;

public class SublistSearch {

	// A Linked List node
	static class Node {
		int data;
		Node next;

		Node(int element) {
			this.data = element;
		}

		public Node() {
		}
	}

	static class CustomList {
		Node head;
		int count;

		/**
		 * Find the sublist
		 * 
		 * @param first
		 * @param second
		 * @return
		 */
		boolean findList(Node first, Node second) {
			Node headA = first;
			Node headB = second;

			if (first == null && second == null) {
				return true;
			}	

			if (first == null || (first != null && second == null)) {
				return false;
			}
			
			while (second != null) {
				headB = second;
				int count = 0;
				while (headA != null) {
					if (headB == null) {
						return count >=2 ? true : false;
					} else if (headA.data == headB.data) {
						headA = headA.next;
						headB = headB.next;
						count++;
					} else {
						headA = headA.next;;
					}	
				}
				
				headA = first;
				second = second.next;
			}
			return count >=2 || headA == null ? true : false;
		}

		void add(int newElement) {
			Node newNode = new Node(newElement);
			newNode.next = null;

			if (head == null) {
				head = newNode;
			} else {
				Node node = new Node();
				node = head;

				while (node.next != null) {
					node = node.next;
				}

				node.next = newNode;
			}
			count++;
		}

		long size() {

			return this.count;
		}

		boolean isEmpty() {
			return this.size() > 0 ? false : true;
		}

		void get() {

			if (!this.isEmpty()) {
				Node node = this.head;
				while (node.next != null) {
					System.out.print(node.data+", ");
					node = node.next;
				}
			} else {
				System.out.println("List is empty");
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		CustomList listA = new CustomList();
		listA.add(0);
		listA.add(2);
		listA.add(3);
		listA.add(4);
		listA.add(5);
		listA.add(6);
		listA.add(7);

		CustomList listB = new CustomList();
		listB.add(0);
		//listB.add(2);
		listB.add(5);
		listB.add(4);
		
		listA.get();
		listB.get();

		boolean isPresent = listA.findList(listA.head, listB.head);
		System.out.println(isPresent ? "List Found" : "List not found");
		List<String> l = new LinkedList<>();
		List<String> l1 = new LinkedList<>();
		l.containsAll(l1);

	}
}
