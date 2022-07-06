package com.persi.amazon.day3;

public class FindNonRepeatingElement {
	static int findSingle(int array[], int size) {
		// Do XOR of all elements and return
		int result = array[0];
		for (int i = 1; i < size; i++) {
			System.out.println(result+" ^ "+array[i]);
			result = result ^ array[i];
			System.out.println(result);
		}	

		return result;
	}

	// Driver code
	public static void main(String[] args) {
		int ar[] = { 3,5,2,6,4,6,5,2,4 };
		int n = ar.length;
		System.out.println("Element occurring once is " + findSingle(ar, n) + " ");
	}
}
