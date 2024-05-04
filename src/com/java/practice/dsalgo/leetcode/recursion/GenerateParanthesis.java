package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Generate Parentheses
Medium

11835

465

Add to List

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

Hint-Reference:
https://www.youtube.com/watch?v=N-3fyoKD8-k

 */
public class GenerateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String> generateParenthesis(int n) {
        List<String> paranthesisList = new ArrayList<>();
        backTracking(paranthesisList, "", 0, 0, n);
        return paranthesisList;
    }
    
    private void backTracking(List<String> paranthesisList, String paranthesis, int open,
                             int close, int n) {
        if(paranthesis.length() == n*2) {
            paranthesisList.add(paranthesis);
            return;
        }
        
        if(open < n) {
            backTracking(paranthesisList, paranthesis + "(", open + 1, close, n);
        }
        
        if(close < open) {
            backTracking(paranthesisList, paranthesis + ")", open, close + 1, n);
        }
    }

}
