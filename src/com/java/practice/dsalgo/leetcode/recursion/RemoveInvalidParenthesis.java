package com.java.practice.dsalgo.leetcode.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author saurabh
 *
 *Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return all the possible results. You may return the answer in any order.

 

Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:

Input: s = ")("
Output: [""]
 

Constraints:

1 <= s.length <= 25
s consists of lowercase English letters and parentheses '(' and ')'.
There will be at most 20 parentheses in s.
 *
 *
 *Youtube Hint-Reference: 
 *https://www.youtube.com/watch?v=-IbZA4WckOc
 */
public class RemoveInvalidParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String parenString = "()())()";
		System.out.println(Arrays.toString(removeInvalidParentheses(parenString).toArray()));
		
	}
	
    public static List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return new LinkedList<String>();
        }
        
        int removeParenCount = removeParenthesisCount(s);
        Set<String> possibilities = new HashSet<>();
        dfs(s, 0, removeParenCount, 0, "", possibilities);
        return setToList(possibilities);
    }
    
    private static int removeParenthesisCount(String s) {
        int open = 0;
        int removeParenCount = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                open++;
            }
            else if(ch == ')') {
                if(open == 0) {
                    removeParenCount++;
                } 
                else {
                    open--;
                }
            }
        }
        removeParenCount += open;
        return removeParenCount;
    }
    
    private static void dfs(String s, int index, int removeParenCount, 
                    int open, String temp, Set<String> possibilities) {
        if(index == s.length()) {
            if(removeParenCount == 0 && open == 0) {
                possibilities.add(temp);
            }
            return;
        }
        
        if(removeParenCount < 0) {
            return;
        }
        
        if(s.charAt(index) == '(') {
            dfs(s, index + 1, removeParenCount, open + 1, temp + "(", possibilities);
            dfs(s, index + 1, removeParenCount - 1, open, temp, possibilities);
        }
        else if(s.charAt(index) == ')') {
            if(open > 0) {
                dfs(s, index + 1, removeParenCount, open - 1, temp + ")", possibilities);
            }
            dfs(s, index + 1, removeParenCount - 1, open, temp, possibilities);
        }
        else {
            dfs(s, index + 1, removeParenCount, open, temp + s.charAt(index), possibilities);
        }
    }
    
    private static List<String> setToList(Set<String> possibilities) {
        List<String> listOfPossStrings = new LinkedList<> ();
        for(String possibility: possibilities) {
            listOfPossStrings.add(possibility);
        }
        return listOfPossStrings;
    }

}
