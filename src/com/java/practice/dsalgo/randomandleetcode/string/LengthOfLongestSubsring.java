package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author saurabh
 *
 *Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
 */
public class LengthOfLongestSubsring {

public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int result = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while(j < s.length()) {
            char c = s.charAt(j);
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
           
            // if map size is greater than k increase slow pointer
            // and reduce map size to k
            while(charMap.size() > k) {
                char adjustChar = s.charAt(i);
                if(charMap.get(adjustChar) == 1) {
                    charMap.remove(adjustChar);
                }
                else {
                    charMap.put(adjustChar, charMap.get(adjustChar) - 1);
                }
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	}

}
