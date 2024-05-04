package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author saurabh
 *
 *47. Permutations II
Medium

4306

89

Add to List

Share
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

Hint-Reference: 
https://www.youtube.com/watch?v=rR9rPCYIwKc
 */
public class Permutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> uniquePerms = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return uniquePerms;
        }
        permuteUnique(uniquePerms, nums, 0);
        return uniquePerms;
    }
    
    private void permuteUnique(List<List<Integer>> uniquePerms, int[] nums, int index) {
        if(index == nums.length) {
            List<Integer> uniquePermutation = new ArrayList<>();
            for(int num: nums) {
                uniquePermutation.add(num);
            }
            uniquePerms.add(uniquePermutation);
        }
        for(int i=index; i<nums.length; i++) {
            if(i != index && !canPermutate(index, i, nums)) {
                continue;
            }
            swap(nums, index, i);
            permuteUnique(uniquePerms, nums, index + 1);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private boolean canPermutate(int index, int curr, int[] nums) {
        for(int i= index; i<curr; i++) {
            if(nums[i] == nums[curr]) {
                return false;
            }
        }
        return true;
    }

}
