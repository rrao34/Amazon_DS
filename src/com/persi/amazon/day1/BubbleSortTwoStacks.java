package com.persi.amazon.day1;

import java.util.Arrays;
import java.util.Stack;

public class BubbleSortTwoStacks {
	/**
	 * @param arr
	 * @param arrSize
	 */
	static void bubbleSortStack(int arr[], int arrSize) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		for (int num : arr) {
			stack1.push(num);
		}

		for (int i = 0; i < arrSize; i++) {
			// alternatively
			if (i % 2 == 0) {
				while (!stack1.isEmpty()) {
					int lastElement = stack1.pop();

					if (stack2.isEmpty()) {
						stack2.push(lastElement);
					} else if (stack2.peek() > lastElement) {
						// swapping
						int temp = stack2.pop();
						stack2.push(lastElement);
						stack2.push(temp);
					} else {
						stack2.push(lastElement);
					}
				}

				// tricky step
				arr[arrSize - 1 - i] = stack2.pop();
			} else {
				while (!stack2.isEmpty()) {
					int lastElement = stack2.pop();

					if (stack1.isEmpty()) {
						stack1.push(lastElement);
					} else if (stack1.peek() > lastElement) {
						int temp = stack1.pop();
						stack1.push(lastElement);
						stack1.push(temp);
					} else {
						stack1.push(lastElement);
					}
				}

				// tricky step
				arr[arrSize - 1 - i] = stack1.pop();
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	// Driver Method
	public static void main(String[] args) {
		int arr[] = { 15, 12, 44, 2, 5, 10 };
		bubbleSortStack(arr, arr.length);
	}
}
