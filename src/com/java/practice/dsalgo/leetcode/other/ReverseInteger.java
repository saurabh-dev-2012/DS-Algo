package com.java.practice.dsalgo.leetcode.other;
/**
 * 
 * @author saurabh
 *
 *Reverse Integer
Medium

6735

9420

Add to List

Share
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1


 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int reverse(int x) {
        int reverse = 0;
        int unitPlace = 0;
        while(x != 0) {
            unitPlace = x % 10;
            x = x / 10;
            if(reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && unitPlace > 7)) {
                return 0;
            }
            if(reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && unitPlace < -8)) {
                return 0;
            }
            reverse = reverse * 10 + unitPlace;
        }
        return reverse;
    }

}
