package com.persi.amazon.othertasks;

public class DevideStringIntoGivenNoOfParts {

	public static void main(String[] args) {
		String str = "aaaabbbbccccD";
		int numOfParts = 6;
		StringBuilder sb = new StringBuilder(str);
		String[] result = null;;
		if (str.length()%2 == 0) {
			result = new String[str.length()/2];
		} else {
			result = new String[str.length()/2+1];
		}
		devideString(sb, numOfParts, result, 0);
		printable(result);

	}

	private static void printable(String[] result) {
		
		for (int i = 0; i < result.length; i++) {
			if (result[i] == null) break;
			System.out.print(result[i]+" ");
		}
		
	}

	private static void devideString(StringBuilder str, int numOfParts, String[] result, int count) {
		if (str == null || str.length() <= 0) {
			return;
		}
			
		if (numOfParts > str.length()) {
			result[count] = str.substring(0, str.length()).toString();
		} else {
			result[count] = str.substring(0, numOfParts).toString();
			devideString(str.delete(0, numOfParts), numOfParts, result, ++count);
		}
	}

}
