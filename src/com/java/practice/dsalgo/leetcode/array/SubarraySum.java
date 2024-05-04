package com.java.practice.dsalgo.leetcode.array;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author saurabh
 *
 *
 *Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

Hint-Reference:
https://www.youtube.com/watch?v=20v8zSo2v18
 */
public class SubarraySum {

public static void main(String[] args) {
// TODO Auto-generated method stub
int[] nums = {-1, -1, 1};
System.out.println(subarraySum(nums, 0));
}

public static int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // Initial target add
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}