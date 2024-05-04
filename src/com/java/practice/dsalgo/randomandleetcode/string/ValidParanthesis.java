package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.Stack;

/**
 * 
 * @author saurabh
 *
 *Valid Parentheses
Easy

11290

483

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
public class ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
