package com.java.practice.dsalgo.leetcode.other;
/**
 * 
 * @author saurabh
 *
 *Permutation in String
Medium

4182

121

Add to List

Share
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

Hint-Reference: 

https://www.youtube.com/watch?v=24r8fvX8pek
 */
public class PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1 == null || s1.length() == 0 || s1Len > s2Len) {
            return false;
        }
        
        // initialize frequncy counters for string s1 characters
        int[] frequency = new int[26];
        for(int i=0; i<s1Len; i++) {
            frequency[s1.charAt(i) - 'a']++;
        }
        
        // use sliding window for string s2 to check permutation
        for(int i=0; i<s2Len; i++) {
            frequency[s2.charAt(i) - 'a']--;
            if(i - s1Len >= 0) {
                frequency[s2.charAt(i - s1Len) - 'a']++;
            }
            if(allZeros(frequency)) {
                return true;
            }
        }
        return false;
        
    }
    
    private boolean allZeros(int[] frequency) {
        for(int i=0; i<26; i++) {
            if(frequency[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
