package com.java.practice.dsalgo.leetcode.dynamicprogramming;
/**
 * 
 * @author saurabh
 *
 *Edit Distance
Hard

7705

89

Add to List

Share
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.

Hint-Reference:

https://www.youtube.com/watch?v=F469rXsQSP4
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minDistance(String word1, String word2) {
        // memoisation store
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        
        return rec(word1, word2, memo);
    }
    
    private int rec(String s1, String s2, int[][] memo) {
        if(s1.length() == 0) {
            return s2.length();
        }
        
        if(s2.length() == 0) {
            return s1.length();
        }
        if(memo[s1.length()][s2.length()] > 0) {
            return memo[s1.length()][s2.length()];
        }
        
        if(s1.charAt(0) == s2.charAt(0)) {
            memo[s1.length()][s2.length()] = rec(s1.substring(1), s2.substring(1), memo);
            return rec(s1.substring(1), s2.substring(1), memo);
        }
        else {
            int op1 = rec(s1, s2.substring(1), memo);
            int op2 = rec(s1.substring(1), s2, memo);
            int op3 = rec(s1.substring(1), s2.substring(1), memo);
            
             if(memo[s1.length()][s2.length()] > 0) {
                return memo[s1.length()][s2.length()];
             }
            
            memo[s1.length()][s2.length()] = 1 + Math.min(op1, Math.min(op2, op3));
            
            return 1 + Math.min(op1, Math.min(op2, op3));
        }
    }

}
