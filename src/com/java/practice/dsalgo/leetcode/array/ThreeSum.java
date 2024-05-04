package com.java.practice.dsalgo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author saurabh
 *
 *Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the Hint-Reference set must not contain duplicate triplets.


Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []


Approach 1: Two Pointers

We will follow the same two pointers pattern as in Two Sum II. It requires the array to be sorted, so we'll do that first. As our BCR is \mathcal{O}(n^2)O(n
2
 ), sorting the array would not change the overall time complexity.

To make sure the result contains unique triplets, we need to skip duplicate values. It is easy to do because repeating values are next to each other in a sorted array.

If you are wondering how to solve this problem without sorting the array, go over the "No-Sort" approach below. There are cases when that approach is preferable, and your interviewer may probe your knowledge there.

After sorting the array, we move our pivot element nums[i] and analyze elements to its right. We find all pairs whose sum is equal -nums[i] using the two pointers pattern, so that the sum of the pivot element (nums[i]) and the pair (-nums[i]) is equal to zero.

As a quick refresher, the pointers are initially set to the first and the last element respectively. We compare the sum of these two elements to the target. If it is smaller, we increment the lower pointer lo. Otherwise, we decrement the higher pointer hi. Thus, the sum always moves toward the target, and we "prune" pairs that would move it further away. Again, this works only if the array is sorted. Head to the Two Sum II Hint-Reference for the detailed explanation.


Algorithm

The implementation is straightforward - we just need to modify twoSumII to produce triplets and skip repeating values.

1. For the main function:

Sort the input array nums.
Iterate through the array:
If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
If the current value is the same as the one before, skip it.
Otherwise, call twoSumII for the current position i.

2. For twoSumII function:

Set the low pointer lo to i + 1, and high pointer hi to the last index.
While low pointer is smaller than high:
If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
If sum is greater than zero, decrement hi.
Otherwise, we found a triplet:
Add it to the result res.
Decrement hi and increment lo.
Increment lo while the next value is the same as before to avoid duplicates in the result.

3. Return the result res.

 */
public class ThreeSum {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i < nums.length && nums[i]<=0; i++) {
            if(i == 0 || nums[i] != nums[i-1]) {
                twoSum(nums, i, result);
            }
        }
        return result;
}
   
    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int low = i+1;
        int high = nums.length - 1;
        while(low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if(sum < 0) {
                low++;
            }
            else if(sum > 0) {
                high--;
            }
            else {
                result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low < high && nums[low] == nums[low-1])
                    low++;
            }
        }
    }
   
   
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */


}
