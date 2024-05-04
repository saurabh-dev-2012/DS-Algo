package com.java.practice.dsalgo.leetcode.searchsort;
/**
 * 
 * @author saurabh
 *
 *Find First and Last Position of Element in Sorted Array
Medium

8921

267

Add to List

Share
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

Hint-Reference: 
https://www.youtube.com/watch?v=c_HH9sakxpY
 */
public class FindFirstAndLastPositionInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        
        if(nums[start] != target) {
            return res;
        }
        
        res[0] = start;
        end = nums.length;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] > target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        res[1] = start - 1 ;

        return res;
    }

}
