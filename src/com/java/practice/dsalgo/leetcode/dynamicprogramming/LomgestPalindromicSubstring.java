package com.java.practice.dsalgo.leetcode.dynamicprogramming;
/**
 * 
 * @author saurabh
 *
 *
 *Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.


Hint-Reference: 
https://www.youtube.com/watch?v=OwjIfAy1OqA

Time Complexity: O(n^2)
Space Complexity: O(1)
 */
public class LomgestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input ="babad";
	}
	
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }
        
        int len = 0;
        int start = 0;
        int end = 0;
        int evenLen = 0;
        int oddLen = 0;
        
        for(int i=0 ; i<s.length(); i++) {
            evenLen = expandAroundCenter(s, i, i);
            oddLen = expandAroundCenter(s, i, i + 1);
            len = Math.max(evenLen, oddLen);
            if(len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }

}
