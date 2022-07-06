package com.persi.amazon.day2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeTwoAdjacentCharacters {
	// Function that returns true if it is possible to rearrange the characters of
	// the string such that no two consecutive characters are same
	static boolean isPossible(char[] str) {

		// To store the frequency of each of the character
		Map<Character, Integer> freq = new HashMap<>();

		// To store the maximum frequency so far
		int max_freq = 0;
		for (int j = 0; j < (str.length); j++) {
			if (freq.containsKey(str[j])) {
				freq.put(str[j], freq.get(str[j]) + 1);
				if (freq.get(str[j]) > max_freq)
					max_freq = freq.get(str[j]);
			} else {
				freq.put(str[j], 1);
				if (freq.get(str[j]) > max_freq)
					max_freq = freq.get(str[j]);
			}
		}

		// If possible
		if (max_freq <= (str.length - max_freq + 1))
			return true;
		
		return false;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "geeksforgeeks";

		if (isPossible(str.toCharArray())) {
			System.out.println("Yes");
			Rearrange.rearrangeString(str);
		} else {
			System.out.println("No");
		}
	}
	
	static class Key{
	    char character;
	    int freq;

	    Key(char character, int freq){
	        this.character = character;
	        this.freq = freq;
	    }
	}
	//Implementing our comparator to compare the keys
	static class KeyComparator implements Comparator<Key>{
	    public int compare(Key key1, Key key2){
	        if(key1.freq < key2.freq){
	            return 1;
	        }else if(key1.freq > key2.freq) {
	            return -1;
	        } return 0;
	    }
	}

	static public class Rearrange {
	    //this method rearranges string so two adjacent characters are not same
	    static void rearrangeString(String value){
	        int len = value.length();
	        int numbersOfAlphabates= 26;
	        //creating an array to store the count of the characters
	        int[] characterCount = new int[numbersOfAlphabates];//
	        //loop to find and set the values of the array
	        for(int i = 0; i < len; i++){
	            characterCount[value.charAt(i) - 97] += 1;
	        }

	        PriorityQueue<Key> pQueue = new PriorityQueue<>(new KeyComparator());

	        //adding keys to our priority queue if the count of that character is > 0
	        for(int i = 97; i <= 'z'; i++){
	            if((characterCount[i-97]) > 0){
	                pQueue.add(new Key((char)i, characterCount[i-97]));
	            }
	        }

	        value = "";

	        Key prev = new Key('#', -1);

	        while(pQueue.size() > 0) {
	            Key k = pQueue.poll();//this method removes and returns the an element from the head of the queue
	            value += k.character;

	            if (prev.freq > 0) {
	                pQueue.add(prev);
	            }

	            k.freq -= 1;
	            prev = k;
	        }

	        if(value.length() != len){
	            System.out.println("NOT POSSIBLE");
	        }else{
	            System.out.println(value);
	        }
	    }
	}
}
