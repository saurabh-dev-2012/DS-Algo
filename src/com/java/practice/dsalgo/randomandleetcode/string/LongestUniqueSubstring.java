package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestUniqueSubstring {

// #1 Hint-Reference
// public static int longestUniqueSubsttr(String s)
// {
//
//    // Creating a set to store the last positions of occurrence
//    HashMap<Character, Integer> seen = new HashMap<>();
//    int maximum_length = 0;
//
//    // starting the initial point of window to index 0
//    int start = 0;
//
//    for(int end = 0; end < s.length(); end++)
//    {
//      // Checking if we have already seen the element or not
//      if(seen.containsKey(s.charAt(end)))
//      {
//        // If we have seen the number, move the start pointer
//        // to position after the last occurrence
//        start = Math.max(start, seen.get(s.charAt(end)) + 1);
//      }
//
//      // Updating the last seen value of the character
//      seen.put(s.charAt(end), end);
//      maximum_length = Math.max(maximum_length, end-start + 1);
//    }
//    return maximum_length;
// }
public static int longestUniqueSubsttr(String s) {
// Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        Map<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        String longestSubstring = "";
        int lengthOfLongestSubstring = 0;
        for(int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if(!charMap.containsKey(ch)) {
                charMap.put(ch, i);
            }
            else {
                i = charMap.get(ch);
                charMap.clear();
            }
            if(charMap.size() > lengthOfLongestSubstring) {
                longestSubstring = charMap.keySet().toString();
                lengthOfLongestSubstring = charMap.size();
            }
        }
        System.out.println("Longest substring is " + longestSubstring);
        return lengthOfLongestSubstring;
   
}

	 // Driver code
	 public static void main(String []args)
	 {
	   String s = "abcabcd";
	//    String s = "dvdf";
	   System.out.println("The input String is " + s);
	   int length = longestUniqueSubsttr(s);
	   System.out.println("The length of the longest non-repeating character substring is " + length);
	 }
}

