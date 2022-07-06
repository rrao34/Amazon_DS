package com.persi.amazon.day1;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class SortStackUsingRecursion {
	public static void sortedInsert(Stack<Integer> stack, int key) {
		if (stack.isEmpty() || key > stack.peek()) {
			stack.push(key);
			return;
		}

		int top = stack.pop();

		sortedInsert(stack, key);

		stack.push(top);
	}


	public static void sortStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int top = stack.pop();

		sortStack(stack);

		sortedInsert(stack, top);
	}
	
	static void printStackReverseOrder(Stack<Integer> s) {
		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(30, -5, 18, 14, -3);

		Stack<Integer> stack = new Stack<>();
		stack.addAll(list);

		System.out.println("Stack before sorting: " + stack);
		sortStack(stack);
		System.out.println("Stack after sorting: " + stack);
		System.out.print("Stack after sorting in reverse order: ");
		
		printStackReverseOrder(stack);
	}
}
