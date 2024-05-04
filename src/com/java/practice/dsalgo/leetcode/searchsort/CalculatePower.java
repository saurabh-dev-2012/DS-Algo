package com.java.practice.dsalgo.leetcode.searchsort;
/**
 * 
 * @author saurabh
 *
 *Pow(x, n)
Medium

3784

4871

Add to List

Share
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

Hint-Reference: 
https://www.youtube.com/watch?v=7t66cSsOPZI

 */
public class CalculatePower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public double myPow(double x, int n) {
        if(n >= 0) {
            return positivePow(x, n);
        }
        return negativePow(x, n);
    }
    
    private double positivePow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        
        double result = positivePow(x, n/2);
        
        if(n % 2 == 0) {
            return result * result;
        }
        else {
            return x * result * result;
        }
    }
    
    private double negativePow(double x, int n) {
        if(n == -1) {
            return 1/x;
        }

        double result = negativePow(x, n/2);

        if(n % 2 == 0) {
            return result * result;
        }
        else {
            return (1/x) * result * result;
        }
    }

}
