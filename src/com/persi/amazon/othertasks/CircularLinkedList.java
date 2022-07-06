package com.persi.amazon.othertasks;

public class CircularLinkedList {
	
	static class Node {

	    int data;
	    Node nextNode;

	    public Node(int data) {
	        this.data = data;
	    }
	}
	
	static public class LinkedList {
	    private Node head = null;
	    private Node tail = null;

	    /**
	     * @param data
	     */
	    public void addNode(int data) {
	        Node newNode = new Node(data);

	        if (head == null) {
	            head = newNode;
	        } else {
	            tail.nextNode = newNode;
	        }

	        tail = newNode;
	        tail.nextNode = head;
	    }
	    
	    /**
	     * @param searchValue
	     * @return
	     */
	    public boolean containsNode(int searchValue) {
	        Node currentNode = head;

	        if (head == null) {
	            return false;
	        } else {
	            do {
	                if (currentNode.data == searchValue) {
	                    return true;
	                }
	                currentNode = currentNode.nextNode;
	            } while (currentNode != head);
	            return false;
	        }
	    }

		/**
		 * @param head
		 */
		public void print(Node head) {
			Node currentNode = head;
			if(head != null) {
				do {
					System.out.println(head.data);
					head = head.nextNode;
				} while(currentNode != head) ;
			}
			
			
		}
	}
	
	public static void main(String []args) {
	    LinkedList list = new LinkedList();

	    list.addNode(13);
	    list.addNode(7);
	    list.addNode(24);
	    list.addNode(1);
	    list.addNode(8);
	    list.addNode(37);
	    list.addNode(46);
	    
	    Node node1 = new Node(13);
	    Node node2 = new Node(17);
	    Node node3 = new Node(24);
	    Node node4 = new Node(18);
	    Node node5 = new Node(37);
	    Node node6 = new Node(46);
	    
	    node1.nextNode = node2;
	    node2.nextNode = node3;
	    node3.nextNode = node4;
	    node4.nextNode = node5;
	    node5.nextNode = node6;
	    node6.nextNode = node1;
	    

	   list.print(node1);
	   System.out.println("Is Element contains : "+list.containsNode(1));
	}
}
