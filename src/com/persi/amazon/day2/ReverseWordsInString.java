package com.persi.amazon.day2;

import java.util.Stack;

public class ReverseWordsInString {

	static void reverse(char str[], int start, int end) {
		// Temporary variable to store character
		char temp;

		while (start <= end) {
			// Swapping the first and last character
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	// Function to reverse words
	static char[] reverseWords(char[] s) {
		// Reversing individual words as explained in the first step

		int start = 0;
		for (int i = 0; i < s.length; i++) {
			// If we see a space, we reverse the previous word (word between the indexes
			// start and end-1 i.e., s[start..end-1]
			if (s[i] == ' ') {
				reverse(s, start, i);
				start = i + 1;
			}
		}

		// Reverse the last word
		reverse(s, start, s.length - 1);

		// Reverse the entire String
		reverse(s, 0, s.length - 1);
		return s;
	}
	
	private static void reverseUsingStack(String value) {
		Stack<String> queue = new Stack<>();
		int startIndex = 0;
		for(int i=0; i<value.length(); i++) {
			if (value.charAt(i) == ' ') {
				queue.add(value.substring(startIndex, i)+" ");
				startIndex = i+1;
			}
		}
		
		while (!queue.isEmpty()) {
			System.out.print(queue.pop());
			
		}
		
	}

	// Driver Code
	public static void main(String[] args) {
		String s = "Write a program Reverse words in a given string";
		
		/*char[] p = reverseWords(s.toCharArray());
		System.out.print(p);*/
		reverseUsingStack(s);
	}
}
