package com.persi.amazon.day1;

public class ModularNodesFromLinkedList {

	static class Node {
		int data;
		Node next;
		int count;

		Node() {
		}

		Node(int data) {
			this.data = data;
		}
	}

	static class CustomLisnkedList {
		Node head;
		long count;

		public CustomLisnkedList() {
			head = null;
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
					System.out.println(node.data);
					node = node.next;
				}
			} else {
				System.out.println("List is empty");
			}
		}
		
		Node modularOfNode(int modularOf, boolean lastModular, boolean firstModuler) {
			if (!isEmpty() && modularOf > 0) {
				Node node = this.head;
				int modulerCount = 0;
				while (node.next != null) {
					if (node.data % modularOf == 0) {
						modulerCount++;
					}
					
					if (firstModuler) {
						node.count = modulerCount;
						
						return node;
					}
					node = node.next;
				}
				node.count = modulerCount;
				return node;
				
			} else {
				System.out.println("List is empty");
				return null;
			}
		}
	}

	public static void main(String[] args) {
		CustomLisnkedList list = new CustomLisnkedList();
		list.add(0);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);

		list.get();
		System.out.println("size of the list is - "+list.size());
		
		Node node = list.modularOfNode(5, true, false);
		System.out.println("Moduler count is - "+node.count+" And last Node is - "+node.data);

	}

}
