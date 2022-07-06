package com.persi.amazon.day2;

public class MinimumDistanceBetweenTwoNumbers {
	
	static int minDist(int arr[], int arrSize, int valA, int valB) {
		// indexForValA and indexForValB will store indices of valA or valB and min_dist will store the minimum
		// difference
		int indexForValA = -1;
		int indexForValB = -1;
		int min_dist = -1;
		for (int i = 0; i < arrSize; i++) {
			if (arr[i] == valA) {
				indexForValA = i;
			} else if (arr[i] == valB) {
				indexForValB = i;
			}
			// If valA and valB both found in array then only find the difference and store it in min_dist
			if (indexForValA != -1 && indexForValB != -1) {
				min_dist = Math.abs(indexForValA - indexForValB);
				break;
			}	
		}

		// If left or right did not found in array
		// then return -1
		if (indexForValA == -1 || indexForValB == -1)
			return -1;
		// return the minimum distance
		else
			return min_dist;
	}

	/* Driver code */
	public static void main(String[] args) {
		int arr[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		int size = arr.length;
		int valA = 3;
		int valB = 6;

		System.out.println("Minimum distance between " + valA + " and " + valB + " is " + minDist(arr, size, valA, valB));
	}
}
