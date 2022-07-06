package com.persi.amazon.day1;

import java.time.LocalTime;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianMaintain {

	// method to calculate med of stream
	public static void printMedian(int[] a) {

		double med = a[0];
		// PriorityQueue is used to manage the order of element based on priority (In
		// this code priority has not be considered)
		// max heap to store the smaller half elements
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());

		// min-heap to store the greater half elements
		PriorityQueue<Integer> greater = new PriorityQueue<>();

		smaller.add(a[0]);
		System.out.print(med+",");

		// reading elements of stream one by one
		/*
		 * At any time we try to make heaps balanced and their sizes differ by at-most
		 * 1. If heaps are balanced,then we declare median as average of
		 * min_heap_right.top() and max_heap_left.top() If heaps are unbalanced,then
		 * median is defined as the top element of heap of larger size
		 */
		for (int i = 1; i < a.length; i++) {

			int x = a[i];

			// case1(left side heap has more elements)
			if (smaller.size() > greater.size()) {
				if (x < med) {
					greater.add(smaller.remove());
					smaller.add(x);
				} else {
					greater.add(x);
				}
				
				med = (double) (smaller.peek() + greater.peek()) / 2;
			}

			// case2(both heaps are balanced)
			else if (smaller.size() == greater.size()) {
				if (x < med) {
					smaller.add(x);
					med = (double) smaller.peek();
				} else {
					greater.add(x);
					med = (double) greater.peek();
				}
			}

			// case3(right side heap has more elements)
			else {
				if (x > med) {
					smaller.add(greater.remove());
					greater.add(x);
				} else
					smaller.add(x);
				med = (double) (smaller.peek() + greater.peek()) / 2;

			}
			System.out.print(med+",");
		}
	}

	// Driver code
	public static void main(String[] args) {

		// stream of integers
		int[] arr = new int[] { 5, 15, 10, 20, 3 };
		System.out.println(LocalTime.now());
		printMedian(arr);
		System.out.println();
		myApproachToMedian(arr);
		System.out.println();
		System.out.println(LocalTime.now());
	}

	private static void myApproachToMedian(int[] arr) {
		double sum = arr[0];
		int count = 2;
		System.out.print(sum+",");
		for (int i=1; i<arr.length; i++) {
			sum = sum+arr[i];
			System.out.print(sum/count+",");
			count++;
		}
		
	}
	
	/*result:
		13:25:31.878
		5.0,10.0,10.0,12.5,10.0,
		5.0,10.0,10.0,12.5,10.6,
		13:25:31.884*/
}
