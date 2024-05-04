package com.java.practice.dsalgo.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

/** 
 * 
 * @author saurabh
 *
 *Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']

 */

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<String> combinations = null;
    String[] mappings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        combinations = new LinkedList<>();
        if(digits == null || digits.isEmpty()) {
            return combinations;
        }
        
        dfs(0, digits, new StringBuilder());
        
        return combinations;
        
    }
    
    private void dfs(int length, String digits, StringBuilder sb) {
        if(length == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        char ch = digits.charAt(length);
        String mapping = mappings[ch - '0'];  
        for(char letter:  mapping.toCharArray()){
            sb.append(letter);
            dfs(length + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
