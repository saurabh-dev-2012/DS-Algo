package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *
 *First Unique Character in a String
Easy

4512

181

Add to List

Share
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.


 */
public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int n = s.length();
        for(char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0; i<n; i++) {
            if(countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
