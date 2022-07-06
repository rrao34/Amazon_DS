package com.persi.amazon.day2;

public class SpaceOptimizationUsingBitManipulations {
	// index >> 5 corresponds to dividing index by 32 index & 31 corresponds to
	// modulo operation of index by 32

	// Function to check value of bit position whether it is zero or one
	static boolean checkbit(int array[], int index) {
		int val = array[index >> 5] & (1 << (index & 31));
		if (val == 0) {
			return false;
		}
		
		return true;
	}

	// Sets value of bit for corresponding index
	static void setbit(int array[], int index) {
		/*System.out.print(index >> 5);System.out.print(", ");
		System.out.print(index & 31);System.out.print(", ");
		System.out.println(1 << (index & 31));*/
		array[index >> 5] |= (1 << (index & 31));
	}

	// Driver code
	public static void main(String args[]) {
		int numA = 3, numB = 9;
		int size = Math.abs(numB - numA);

		// Size that will be used is actual_size/32 ceil is used to initialize the array
		// with positive number
		size = (int) Math.ceil((double) size / 32);

		// Array is dynamically initialized as we are calculating size at run time
		int[] array = new int[size];

		// Iterate through every index from a to b and call setbit() if it is a multiple
		// of 2 or 5
		for (int i = numA; i <= numB; i++) {
			if (i % 2 == 0 || i % 5 == 0) {
				setbit(array, i - numA);
			}
		}	

		System.out.println("MULTIPLES of 2 and 5:");
		for (int i = numA; i <= numB; i++) {
			if (checkbit(array, i - numA)) {
				System.out.print(i + " ");
			}	
		}
	}
}
