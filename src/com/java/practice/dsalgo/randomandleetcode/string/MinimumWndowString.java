package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author saurabh
 *
 *Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Youtube Explanation: https://www.youtube.com/watch?v=nMaKzLWceFg
 */
public class MinimumWndowString {

public static void main(String[] args) {
// TODO Auto-generated method stub
	String s = "ADOBECODEBANC";
	String t = "ABC";
	System.out.println(minWindow(s, t));
}

//    public String minWindow(String s, String t) {
//       
//        if(s == null || s.length() == 0 || s.length() < t.length()) {
//            return "";
//        }
//        // Map to store string t's character counts
//        Map<Character, Integer> tCharMap = new HashMap<>();
//        //Initialize map with char values from t string
//        for(char ch : t.toCharArray()) {
//            if(tCharMap.containsKey(ch)) {
//                tCharMap.put(ch, tCharMap.get(ch) + 1);
//            }
//            else {
//                tCharMap.put(ch,1);
//            }
//        }
//        // Initialize vars for sliding window
//        int start = 0;
//        int minLength = Integer.MAX_VALUE;
//        int minLeft = 0;
//        int count = 0;
//        for(int i=0; i<s.length(); i++) {
//            // reduce count from map as we find the character
//            char ch = s.charAt(i);
//            if(tCharMap.containsKey(ch)) {
//                int updatedMapCount = tCharMap.get(ch) - 1;
//                tCharMap.put(ch, updatedMapCount);
//                if(updatedMapCount >= 0) {
//                    // increment the var for a covered character in t string
//                    count++;
//                }
//            }
//           
//            //when we found eligible window having all t string chars
//            while(count == t.length()) {
//               
//                // check if we found the min length window
//                if(minLength > (i - start  + 1)) {
//                    // save min window length & start position for the window
//                    minLength = i - start  + 1;
//                    minLeft = start;
//                }
//               
//                if(tCharMap.containsKey(s.charAt(start))) {
//                   
//                    int charCount = tCharMap.get(s.charAt(start));
//                    tCharMap.put(s.charAt(start), charCount + 1);
//                    if(tCharMap.get(s.charAt(start)) > 0) {
//                        count--;
//                    }
//                }
//                start++;
//            }
//        }
//        if(minLength > s.length()) {
//            return "";
//        }
//       
//        return s.substring(minLeft, (minLeft + minLength));
//    }

	public static String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}
	
		Map<Character, Integer> charMap = new HashMap<>();
	
		for (char ch : t.toCharArray()) {
			charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
		}
	
		int count = 0;
		int start = 0;
		int minLength = Integer.MAX_VALUE;
		int minLeft = 0;
	
		for (int i = 0; i < s.length(); i++) {
			// increase count as we find required characters
			if (charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i), charMap.get(s.charAt(i)) - 1);
	
				if (charMap.get(s.charAt(i)) >= 0) {
					count++;
				}
			}
	
			while (count == t.length()) {
	
				// store length & starting position i.e. minLeft for minimum window
				if (minLength > (i - start + 1)) {
					minLength = i - start + 1;
					minLeft = start;
				}
	
				if (charMap.containsKey(s.charAt(start))) {
					charMap.put(s.charAt(start), charMap.get(s.charAt(start)) + 1);
	
					if (charMap.get(s.charAt(start)) > 0) {
						count--;
					}
				}
	
				start++;
			}
	
		}
	
		if (minLength > s.length()) {
			return "";
		}
	
		return s.substring(minLeft, (minLeft + minLength));
	}

}
