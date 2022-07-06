package com.persi.amazon.day1;

import java.util.PriorityQueue;

public class SmallestDerangementOfSequence {
	static void generate_derangement(int N) {
		// Generate Sequence and insert into a priority queue.
		int[] arrayOfN = new int[N + 1];

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			arrayOfN[i] = i;
			priorityQueue.add(arrayOfN[i]);
		}

		// Generate Least derangement
		int[] arrayOfDerangement = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int priorityQueuefetchedvalue = priorityQueue.peek();
			priorityQueue.remove();
			if (priorityQueuefetchedvalue != arrayOfN[i] || i == N) {
				arrayOfDerangement[i] = priorityQueuefetchedvalue;
			} else {
				arrayOfDerangement[i] = priorityQueue.peek();
				priorityQueue.remove();
				priorityQueue.add(priorityQueuefetchedvalue);
			}
		}

		if (arrayOfDerangement[N] == arrayOfN[N]) {
			int t = arrayOfDerangement[N - 1];
			arrayOfDerangement[N - 1] = arrayOfDerangement[N];
			arrayOfDerangement[N] = t;
		}

		// Print Derangement
		for (int i = 1; i <= N; i++) {
			System.out.printf("%d ", arrayOfDerangement[i]);
		}
		System.out.printf("\n");
	}

	// Driver code
	public static void main(String[] args) {
		generate_derangement(3);
	}
}
