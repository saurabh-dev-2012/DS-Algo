package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *Intersection of Two Arrays
Easy

2373

1827

Add to List

Share
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


 */
public class IntersectionOfUnsortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2) {
            set2.add(num);
        }
        
        return intersectionSet(set1, set2);
    }
    
    private int[] intersectionSet(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;
        int[] intersectedArr = new int[set1.size()];
        for(Integer value : set1) {
            if(set2.contains(value)) {
                intersectedArr[count++] = value;
            }
        }
        return Arrays.copyOf(intersectedArr, count);
    }
	

}
