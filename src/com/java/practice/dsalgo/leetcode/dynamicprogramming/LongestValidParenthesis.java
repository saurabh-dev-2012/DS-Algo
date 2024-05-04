package com.java.practice.dsalgo.leetcode.dynamicprogramming;

import java.util.Stack;

/**
 * 
 * @author saurabh
 *
 *Longest Valid Parentheses
Hard

6935

240

Add to List

Share
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

Hint-Reference: 
https://www.youtube.com/watch?v=VdQuwtEd10M
 */
public class LongestValidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }
            }
            
            
        }
        return max;
    }

}
