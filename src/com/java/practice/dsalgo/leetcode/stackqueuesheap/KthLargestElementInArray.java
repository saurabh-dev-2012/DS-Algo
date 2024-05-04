package com.java.practice.dsalgo.leetcode.stackqueuesheap;

import java.util.PriorityQueue;

/**
 * 
 * @author saurabh
 *
 *Kth Largest Element in an Array
Medium

8349

463

Add to List

Share
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104

Hint-Reference:
https://www.youtube.com/watch?v=htqsw5NQMo4

 *
 */
public class KthLargestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

}
