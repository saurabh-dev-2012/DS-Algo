package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *Top K Frequent Elements
Medium

7508

329

Add to List

Share
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Hint-Reference:
https://www.youtube.com/watch?v=CIDmkhR65RY

 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] topKFrequent(int[] nums, int k) {
        
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        
        // intialize map with frequencies
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Initialize bucket with elements at frequency index position
        for(int key : map.keySet()) {
            int frequency = map.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        int[] kElements = new int[k];
        // fill top k elements from bucket i.e. from end to start of bucket
        int count = 0;
        for(int i=bucket.length-1; i>=0; i--) {
            if(bucket[i] != null) {
                for(int j=0; j<bucket[i].size(); j++) {
                    if(count == k) {
                        break;
                    }
                    kElements[count++] = bucket[i].get(j);
                }
            }
            if(count == k) {
                break;
            }
        }
        
        return kElements;
    }

}
