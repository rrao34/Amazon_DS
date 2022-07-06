package com.persi.amazon.day3;

import java.util.HashSet;

public class IntersectionPointOfTwoLinkedLists {
	static class Node {
	    int data;
	    Node next;
	    Node(int data)
	    {
	        this.data = data;
	        this.next = null;
	    }
	}
	static class LinkedListIntersect {
	 
	    // function to find the intersection of two node
	    public static Node megeNode(Node n1, Node n2)
	    {
	        // define hashset
	        HashSet<Node> hasSet = new HashSet<Node>();
	        while (n1 != null) {
	            hasSet.add(n1);
	            n1 = n1.next;
	        }
	       
	        while (n2 != null) {
	            if (hasSet.contains(n2)) {
	                return n2;
	            }
	            n2 = n2.next;
	        }
	        return null;
	    }
	    
	 // function to print the list
	    public static void print(Node n)
	    {
	        Node cur = n;
	        while (cur != null) {
	            System.out.print(cur.data + "  ");
	            cur = cur.next;
	        }
	        System.out.println();
	    }
	}
	    public static void main(String[] args)
	    {
	        // list 1
	        Node node1 = new Node(1);
	        node1.next = new Node(2);
	        node1.next.next = new Node(3);
	        node1.next.next.next = new Node(4);
	        node1.next.next.next.next = new Node(5);
	        node1.next.next.next.next.next = new Node(6);
	        node1.next.next.next.next.next.next = new Node(7);
	        // list 2
	        Node node2 = new Node(10);
	        node2.next = new Node(9);
	        node2.next.next = new Node(8);
	        node2.next.next.next = node1.next.next.next;
	        System.out.print("Node1: ");
	        LinkedListIntersect.print(node1);
	        System.out.print("Node2: ");
	        LinkedListIntersect.print(node2);
	        System.out.println("Intersection point: "+LinkedListIntersect.megeNode(node1, node2).data);
	    }
}
