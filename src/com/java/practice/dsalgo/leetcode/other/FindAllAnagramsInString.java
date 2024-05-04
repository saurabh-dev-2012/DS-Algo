package com.java.practice.dsalgo.leetcode.other;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *
 *Find All Anagrams in a String
Medium

5730

228

Add to List

Share
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

Hint-Reference: 

https://www.youtube.com/watch?v=aZwMXTtEGPo
 */
public class FindAllAnagramsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new LinkedList<>();
        if(s == null || s.length() == 0 || p.length() > s.length()) {
            return indices;
        }
        
        int pLen = p.length();
        int sLen = s.length();
        int[] pFrequency = frequency(p);
        int[] sFrequency = frequency(s.substring(0, pLen));
        
        if(isSame(pFrequency, sFrequency)) {
            indices.add(0);
        }
        
        for(int i=pLen; i<sLen; i++) {
            sFrequency[s.charAt(i-pLen) - 'a']--;
            sFrequency[s.charAt(i) - 'a']++;
            if(isSame(pFrequency, sFrequency)) {
                indices.add(i - pLen + 1);
            }
        }
        
        return indices;
    }
    
    
    private boolean isSame(int[] a, int[] b) {
        for(int i=0; i<26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] frequency(String s) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

}
