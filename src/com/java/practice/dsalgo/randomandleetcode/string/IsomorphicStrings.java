package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 * Isomorphic Strings
Easy

3224

618

Add to List

Share
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.


 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Character> usedCharMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(charMap.containsKey(ch1) && ch2 != charMap.get(ch1)) {
                    return false;
            }
            else {
                if(usedCharMap.containsKey(ch2) && ch1 != usedCharMap.get(ch2)) {
                    return false;
                }
                else {
                    charMap.put(ch1, ch2);
                    usedCharMap.put(ch2, ch1);
                }
            }
            
        }
        
        return true;
    }

}
