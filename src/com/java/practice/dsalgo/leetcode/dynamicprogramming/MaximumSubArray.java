package com.java.practice.dsalgo.leetcode.dynamicprogramming;
/**
 * 
 * @author saurabh
 *
 *Maximum Subarray
Easy

18608

883

Add to List

Share
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) Hint-Reference, try coding another Hint-Reference using the divide and conquer approach, which is more subtle.

Hint-Reference:
https://www.youtube.com/watch?v=VMtyGnNcdPw

 *
 */
public class MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Dynamic Programming, Kadane's Algorithm
	
    public int maxSubArray(int[] nums) {
        int csum = nums[0];
        int osum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(csum >= 0) {
                csum += nums[i];
            }
            else {
                csum = nums[i];
            }
            
            if(csum > osum) {
                osum = csum;
            }
        }
        return osum;
    }
    
    // Divide and Conquer (similar to binary search)
    
    private int[] numsArray;
    
    public int maxSubArray2(int[] nums) {
        numsArray = nums;
        
        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length - 1);
    }
    
    private int findBestSubarray(int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        
        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;
        
        // Iterate from the middle to the beginning.
        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }
        
        // Reset curr and iterate from the middle to the end.
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }
        
        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;
        
        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);
        
        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }
    

}
