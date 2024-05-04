package com.java.practice.dsalgo.leetcode.array;
/**
 * 
 * @author saurabh
 *
 *Plus One
Easy

4173

4137

Add to List

Share
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

Hint-Reference:

Algorithm

Move along the input array starting from the end of array.

Set all the nines at the end of array to zero.

If we meet a not-nine digit, we would increase it by one. The job is done - return digits.

We're here because all the digits were equal to nine. Now they have all been set to zero. We then append the digit 1 in front of the other digits and return the result.
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] plusOne(int[] digits) {
        
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            
            if(digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        // we are here because all digits were 9
        digits = new int[n+1];
        digits[0] = 1;
        
        return digits;
    }

}
