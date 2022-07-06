package com.persi.amazon.day1;

public class SumString {
	String String_sum(String str1, String str2)
	{
	   /* if (str1.length() < str2.length())
	    swap(str1, str2);*/
	 
	    int m = str1.length();
	    int n = str2.length();
	    String ans = "";
	 
	    // sum the str2 with str1
	    int carry = 0;
	    for (int i = 0; i < n; i++) {
	 
	        // Sum of current digits
	        int ds = ((str1.charAt(m - 1 - i) - 0) +
	                (str2.charAt(n - 1 - i) - 0) +
	                carry) % 10;
	 
	        carry = ((str1.charAt(m - 1 - i) - 0) +
	                (str2.charAt(n - 1 - i) - 0) +
	                carry) / 10;
	 
	        ans = (ds + 0) + ans;
	    }
	 
	    for (int i = n; i < m; i++) {
	        int ds = (str1.charAt(m - 1 - i) - 0 +
	                carry) % 10;
	        carry = (str1.charAt(m - 1 - i) - 0 +
	                carry) / 10;
	        ans = (ds + 0) + ans;
	    }
	 
	    if (carry == 0)
	        ans = (carry + 0) + ans;
	    return ans;
	}
	 
	// Returns true of two subStrings of given
	// lengths of str[beg..] can cause a positive
	// result.
	boolean checkSumStrUtil(String str, int beg,
	                    int len1, int len2)
	{
	 
	    // Finding two subStrings of given lengths
	    // and their sum
	    String s1 = str.substring(beg, len1);
	    String s2 = str.substring(beg + len1, len2);
	    String s3 = String_sum(s1, s2);
	 
	    int s3_len = s3.length()-1;
	 
	    // if number of digits s3 is greater then
	    // the available String size
	    if (s3_len > str.length() - len1 - len2 - beg)
	        return false;
	 
	    // we got s3 as next number in main String
	    if (s3 == str.substring(beg + len1 + len2, s3_len)) {
	 
	        // if we reach at the end of the String
	        if (beg + len1 + len2 + s3_len == str.length())
	            return true;
	 
	        // otherwise call recursively for n2, s3
	        return checkSumStrUtil(str, beg + len1, len2,
	                                            s3_len);
	    }
	 
	    // we do not get s3 in main String
	    return false;
	}
	 
	// Returns true if str is sum String, else false.
	boolean isSumStr(String str)
	{
	    int n = str.length();
	 
	    // choosing first two numbers and checking
	    // whether it is sum-String or not.
	    for (int i = 1; i < n; i++)
	        for (int j = 1; i + j < n; j++)
	            if (checkSumStrUtil(str, 0, i, j))
	                return true;
	 
	    return false;
	}
	 
	// Driver code
	public static void main(String ars[])
	{
		SumString sumObj = new SumString();
		sumObj.isSumStr("1212243660");
		sumObj.isSumStr("123456787");
	    
	}
}
