package com.java.practice.dsalgo.leetcode.searchsort;
/**
 * 
 * @author saurabh
 *
 *Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1


 */
public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int mySqrt(int x) {
		if (x < 2) {
			return x;
		}

		int mid, left = 2, right = x / 2;
		long num = 0;

		while (left <= right) {
			mid = left + (right - left) / 2;
			num = (long) mid * mid;
			if (num > x) {
				right = mid - 1;
			} else if (num < x) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return right;
	}

}
