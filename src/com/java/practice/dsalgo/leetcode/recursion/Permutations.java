package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 *
 *
 *Hint-Reference: 
 *
 *https://www.youtube.com/watch?v=WD-vqCYm5hc
 */
public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3};
		List<List<Integer>> permutations = permute(nums);
		System.out.println();
	}
	
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> permutations = new ArrayList<>();
    	if(nums == null || nums.length == 0) {
    		return permutations;
    	}
    	permute(nums, 0, permutations);
    	
    	return permutations;
    	
    }
    
    private static void permute(int[] nums, int index, List<List<Integer>> permutations) {
    	if(index == nums.length) {
    		List<Integer> permuation = new ArrayList<>();
    		for(int num : nums) {
    			permuation.add(num);
    		}
    		permutations.add(permuation);
    		return;
    	}
    	for(int i=index; i<nums.length; i++) {
    		swap(nums, i, index);
    		permute(nums, index + 1, permutations);
    		swap(nums, i, index);
    	}
    }
    
    private static void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }

}
