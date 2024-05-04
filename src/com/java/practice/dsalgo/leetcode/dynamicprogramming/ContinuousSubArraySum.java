package com.java.practice.dsalgo.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *Continuous Subarray Sum
Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

 

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1

Hint-Reference: 

https://www.youtube.com/watch?v=G_N0H7tFLTY
 */
public class ContinuousSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        // return true for k==0 if any subarray's sum is equal to 0
        if(k == 0) {
            for(int i=0; i<nums.length - 1; i++) {
                if(nums[i] + nums[i+1] == 0) {
                    return true;
                }
            }
            return false;
        }
        //Map to store sum of mods of sum of previous + current values with k
        // i.e. [23,2,4,6,7] k=6
        // map{ 0: -1, 5:0, 1:1, 5:2}
        //
        Map<Integer,Integer> subArrayMap = new HashMap<>();
        subArrayMap.put(0, -1);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if(subArrayMap.containsKey(mod)) {
                if(i - subArrayMap.get(mod) > 1){
                    return true;
                }
            }
            else {
                subArrayMap.put(mod, i);
            }
        }
        return false;
    }

}
