package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author saurabh
 *
 *Longest Substring with At Most Two Distinct Characters
Medium

1711

25

Add to List

Share
Given a string s, return the length of the longest substring that contains at most two distinct characters.

 

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
 

Constraints:

1 <= s.length <= 105
s consists of English letters.

Hint-Reference:
https://www.youtube.com/watch?v=1sFL8yjMcwM

 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        int slow = 0;
        int fast = 0;
        int result = 0;
        int n = s.length();
        
        Map<Character, Integer> charMap = new HashMap<>(); 
        
        while (fast < n) {
            
            char c = s.charAt(fast);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            
            while (charMap.size() > 2) {
                char slowChar = s.charAt(slow);
                int freq = charMap.get(slowChar);
                
                if(freq == 1) {
                    charMap.remove(slowChar);
                }
                else {
                    charMap.put(slowChar, charMap.get(slowChar) - 1);
                }
                slow++;
            }
            
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        
        return result;
    }

}
