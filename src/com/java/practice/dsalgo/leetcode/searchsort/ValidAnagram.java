package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 * Valid Anagram
Easy

4866

214

Add to List

Share
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your Hint-Reference to such a case?

Hint-Reference:

T: O(n)
S: O(n)
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        
        if(s == null || t == null) {
            return false;
        }
        
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        for(char ch : charMap.keySet()) {
            if(charMap.get(ch) != 0) {
                return false;
            }
        }
        
        return true;
    }

}
