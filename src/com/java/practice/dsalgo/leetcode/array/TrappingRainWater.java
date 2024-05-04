package com.java.practice.dsalgo.leetcode.array;
/**
 * 
 * 
 *@author saurabh
 *
 *Trapping Rain Water
Hard

17317

244

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

Hint-Reference:
https://www.youtube.com/watch?v=gIZSOpW-SN0


 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int trap(int[] height) {
        int max = 0;
        int maxIndex = 0;
        int totalWater = 0;
        int n = height.length;
        
        // store max height, index
        for(int i=0; i<n; i++) {
            if(height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        
        int leftMax = 0;
        // Part 1: Calculate left part's most water
        for(int i=0; i<maxIndex; i++) {
            leftMax = Math.max(leftMax, height[i]);
            int water = Math.min(leftMax, max) - height[i];
            totalWater += water;
        }
        
        leftMax = 0;
        //Part 2: Calculate right part's most water
        for(int i=n-1; i>maxIndex; i--) {
            leftMax = Math.max(leftMax, height[i]);
            int water = Math.min(leftMax, max) - height[i];
            totalWater += water;
        }
        
        return totalWater;
    }

}
