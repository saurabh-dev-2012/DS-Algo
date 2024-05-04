package com.java.practice.dsalgo.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author saurabh
 *
 *Partition to K Equal Sum Subsets
Medium

4438

265

Add to List

Share
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
Accepted
185,828
Submissions
411,444
Seen this question in a real interview before?

Hint-Reference:

https://www.youtube.com/watch?v=rszwy53vaP0

https://www.youtube.com/watch?v=TvvGj1FtHIk

 *
 */
public class PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] nums = {2,2,2,2,3,4,5};
      int k = 4;
      System.out.println(canPartitionKSubsets(nums, k));	  
	}
	
	static boolean canPart = false;

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0 || nums.length < k) {
			return false;
		}

		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}

		if (k > n || sum % k != 0) {
			return false;
		}
		int[] subsetSum = new int[k];
		List<List<Integer>> subsetList = new ArrayList<>();
		for (int j = 0; j < k; j++) {
			subsetList.add(new ArrayList<>());
		}
		canPartition(nums, 0, n, k, subsetSum, 0, subsetList);
		return canPart;
	}

	private static void canPartition(int[] nums, int idx, int n, int k, int[] subsetSum, int nos,
			List<List<Integer>> subsetList) {

		if (idx == nums.length) {
			if (nos == k) {
				boolean isCorrectSum = true;
				for (int i = 0; i < subsetSum.length - 1; i++) {
					if (subsetSum[i] != subsetSum[i+1]) {
						isCorrectSum = false;
						break;
					}
				}

				if(isCorrectSum) {
					for(List<Integer> partition : subsetList) {
						System.out.println(" Partition: "+partition);
					}
					System.out.println();
					canPart = isCorrectSum;
					return;
				}

			}
			return;
		}

		for (int j = 0; j < subsetList.size(); j++) {
			if (subsetList.get(j).size() > 0) {
				subsetList.get(j).add(nums[idx]);
				subsetSum[j] += nums[idx];
				canPartition(nums, idx + 1, n, k, subsetSum, nos, subsetList);
				subsetSum[j] -= nums[idx];
				subsetList.get(j).remove(subsetList.get(j).size() - 1);
			} else {
				subsetList.get(j).add(nums[idx]);
				subsetSum[j] += nums[idx];
				canPartition(nums, idx + 1, n, k, subsetSum, nos + 1, subsetList);
				subsetSum[j] -= nums[idx];
				subsetList.get(j).remove(subsetList.get(j).size() - 1);
				break;
			}
		}

	}

}
