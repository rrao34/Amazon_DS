package com.persi.amazon.day1;

import java.time.LocalTime;

/**
 * @author Rohit Rao
 *
 */
public class NumberRearrangeAtEvenAndOddPlaces {

	static void rearrange(int a[], int size) {
		int positive = 0, negative = 1, temp;

		while (true) {

			/*
			 * Move forward the positive pointer till negative number number not encountered
			 */
			while (positive < size && a[positive] >= 0)
				positive += 2;

			/*
			 * Move forward the negative pointer till positive number number not encountered
			 */
			while (negative < size && a[negative] <= 0)
				negative += 2;

			// Swap array elements to fix their position.
			if (positive < size && negative < size) {
				temp = a[positive];
				a[positive] = a[negative];
				a[negative] = temp;
			}

			/*
			 * Break from the while loop when any index exceeds the size of the array
			 */
			else
				break;
		}
	}

	// Driver code
	public static void main(String args[]) {
		int arr[] = { 1, -3, -2, 6, -3, 6, 7, -4, 9, 10 };
		int n = arr.length;
		System.out.println(LocalTime.now());
		rearrange(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(LocalTime.now());
		
		
		System.out.println("--------------My Approach------------------");
		System.out.println(LocalTime.now());
		myApproachToRearrange(arr);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println(LocalTime.now());
	}

	
	/**
	 * 
	 */
	private static void myApproachToRearrange(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0 && i+1 % 2 == 1) { // odd
				continue;
			} else if (arr[i] < 0 && i+1 % 2 == 0) {// even
				continue;
			} else {
				if (arr[i] < 0 && i+1 % 2 == 1) {
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[j] > 0 && j % 2 == 0) {
							swapNum(i, j, arr);break;
						}
					}
				}
				
				
				
			}

		}

	}

	/**
	 * @param i
	 * @param j
	 * @param arr
	 */
	private static void swapNum(int i, int j, int[] arr) {
		int sum = arr[i];
		arr[i] = arr[i]+arr[j];
		arr[j] = arr[i]-sum;
		
	}
	
	/* Result:
	 * 
	14:29:08.946
	1 -3 5 -3 6 6 7 -4 9 10 
	14:29:08.948
	--------------My Approach------------------
	14:29:08.948
	1 -3 5 -3 6 6 7 -4 9 10 
	14:29:08.948*/


}
