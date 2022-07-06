package com.persi.amazon.day1;

import java.util.Arrays;

public class MinHeapToMaxHeapConversion {// return left child of `A[i]`

	// Recursive function to implement the heapify-down algorithm. The node at index
	// `i` and its two direct children violates the heap property
	private static void heapify(int[] array, int index, int arraySize) {
		// get left and right child of node at index `i`
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		int smallest = index;

		// compare `A[i]` with its left and right child and find the smallest value
		if (left < arraySize && array[left] < array[index]) {
			smallest = left;
		}

		if (right < arraySize && array[right] < array[smallest]) {
			smallest = right;
		}

		// swap with a child having lesser value and call heapify-down on the child
		if (smallest != index) {
			swap(array, index, smallest);
			heapify(array, smallest, arraySize);
		}
	}

	// Utility function to swap two indices in the array
	private static void swap(int[] array, int index, int smallest) {
		int temp = array[index];
		array[index] = array[smallest];
		array[smallest] = temp;
	}

	// Function to convert a max-heap into a min-heap
	public static void convert(int[] array) {
		// Build-Heap: Call heapify starting from the last internal node all the way up
		// to the root node
		int counter = (array.length - 2) / 2;
		for (int i=counter; i>= 0; i--) {
			heapify(array, i, array.length);
		}
	}

// Convert max-heap into min-heap in linear time
	public static void main(String[] args)
	{
		/*
            	   9
            	 /   \
            	/     \
               4       7
              / \     / \
             /   \   /   \
            1    -2 6     5
		*/

		// an array representing the max-heap
		int[] A = { 9,4,7,1,-2,6,5 };

		// build a min-heap by initializing it by the given array
		convert(A);

		// print the min-heap
		/*
            	   -2
            	 /    \
            	/      \
               1        5
              / \      / \
             /   \    /   \
            9     4  6     7
		*/

		System.out.println(Arrays.toString(A));
	}
}
