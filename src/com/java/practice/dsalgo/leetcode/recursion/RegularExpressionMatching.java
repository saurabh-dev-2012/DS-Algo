package com.java.practice.dsalgo.leetcode.recursion;
/**
 * 
 * @author saurabh
 *
 *Regular Expression Matching
Hard

7399

1030

Add to List

Share
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 

Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

Hint-Reference: 
https://www.youtube.com/watch?v=vTBGPZQVbUc
 */
public class RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return match(0, 0, s, p);
    }
    
    private boolean match(int i, int j, String s, String p) {
        if(j == p.length()) {
            return i == s.length();
        }
        
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans = false;
        // aaaaa
        // a*
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            ans = (firstMatch && match(i + 1, j, s, p)) || match(i, j+2, s, p); 
        }
        else {
            //ab
            //a*
            ans = firstMatch && match(i+1, j+1, s, p);
        }
        memo[i][j] = ans;
        return ans;
    }

}
