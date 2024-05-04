package com.java.practice.dsalgo.leetcode.array;

import java.util.Arrays;

/**
 * 
 * @author saurabh
 *
 *
 *3Sum Closest
Medium

5264

231

Add to List

Share
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one Hint-Reference.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
 

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104

Hint-Reference:
https://www.youtube.com/watch?v=BS7_bRsJFiI

Time Complexity : O(n^2)
Space complexity: O(1)

 */
public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        
        for(int i=0; i<nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];
                if(currentSum < target) {
                    start++;
                }
                else {
                    end--;
                }
                if(Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
            }
        }
        return closestSum;
    }

}
