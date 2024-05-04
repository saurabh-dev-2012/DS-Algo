package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Subsets
Medium

8178

133

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The Hint-Reference set must not contain duplicate subsets. Return the Hint-Reference in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

Hint-Reference: 
https://www.youtube.com/watch?v=B8ZEcSAliM4

 */
public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return subsets;
        }
        backTracking(0, new ArrayList<Integer>(), nums);
        return subsets;
    }
    
    private void backTracking(int start, List<Integer> current, int[] nums) {
       subsets.add(new ArrayList<Integer>(current));
        for(int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            backTracking(i + 1, current, nums);
            current.remove(current.size() - 1);
        }
    }

}
