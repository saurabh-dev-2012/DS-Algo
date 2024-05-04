package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *Strobogrammatic Number II
Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: n = 2
Output: ["11","69","88","96"]
Example 2:

Input: n = 1
Output: ["0","1","8"]
 

Constraints:

1 <= n <= 14


Hint-Reference: 
https://www.youtube.com/watch?v=lnMjTXYLBLQ
 */
public class StrobogramaticNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String> findStrobogrammatic(int n) {
        List<String> stroboNums = new ArrayList<>();
        if(n == 0) {
            return stroboNums;
        }
        if(n == 1) {
            stroboNums.add("0");
            stroboNums.add("1");
            stroboNums.add("8");
            return stroboNums;
        }
        findStrobogrammatic(n, 0, "", stroboNums);
        return stroboNums;
    }
    
    private void findStrobogrammatic(int n, int index, String temp, List<String> stroboNums) {
        if(index == n) {
            stroboNums.add(temp);
            return;
        }
        
        if(index == 0) {
            char[] chars = {'1', '6', '8', '9'};
            for(char c: chars) {
                findStrobogrammatic(n, index + 1, temp + c, stroboNums);
            }
            return;
        }
        // subsequent numbers after first digit can contain 0
        if(index < n/2) {
            char[] chars = {'0', '1', '6', '8', '9'};
            for(char c: chars) {
                findStrobogrammatic(n, index + 1, temp + c, stroboNums);
            }
            return;
        }
        
        // first half of number
        if((n % 2 == 1) && (index == n/2)) {
            char[] chars = {'0', '1', '8'};
            for(char c: chars) {
                findStrobogrammatic(n, index + 1, temp + c, stroboNums);
            }
            return;
        }
        
        char ch = temp.charAt(n - index - 1);
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('0', '0');
        charMap.put('1', '1');
        charMap.put('6', '9');
        charMap.put('8', '8');
        charMap.put('9', '6');
        
        findStrobogrammatic(n, index + 1, temp + charMap.get(ch), stroboNums);
    }

}
