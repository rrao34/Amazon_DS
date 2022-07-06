package com.persi.amazon.day1;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueuesPushOperation {

	static class Stack {
		Queue<Integer> queue1 = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		int curr_size=0;


		/**
		 * @param value
		 */
		void push(int value) {
			curr_size++;

			// Push x first in empty q2
			queue2.add(value);

			// Push all the remaining elements in q1 to q2.
			while (!queue1.isEmpty()) {
				queue2.add(queue1.peek());
				queue1.remove();
			}

			// Swap the names of two queues
			Queue<Integer> q = queue1;
			queue1 = queue2;
			queue2 = q;
		}

		/**
		 * 
		 */
		int pop() {

			// If no elements are there in q1
			if (queue1.isEmpty()) {
				throw new EmptyStackException();
			}
			int pop = queue1.peek();
			queue1.remove();
			curr_size--;
			return pop;
		}

		/**
		 * @return
		 */
		int top() {
			if (queue1.isEmpty()) {
				return -1;
			}
			int pop = queue1.peek();
			this.pop();
			return pop;
		}

		/**
		 * @return
		 */
		int size() {
			return curr_size;
		}
	}

	// driver code
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println("current size: " + stack.size());
		System.out.println(stack.pop());
		//s.pop();
		System.out.println(stack.pop());
		//s.pop();
		System.out.println(stack.pop());

		System.out.println("current size: " + stack.size());
	}
}
