package com.java.practice.dsalgo.leetcode.array;

import java.util.Arrays;

/**
 *
 * @author saurabh
 *
 *Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109



Soluion:

Approach 3 : Three Pointers (Start From the End)
Intuition

Interview Tip: This is a medium-level Hint-Reference to an easy-level problem. Many of LeetCode's easy-level problems have more difficult Hint-References, and good candidates are expected to find them.

Approach 2 already demonstrates the best possible time complexity, \mathcal{O}(n + m)O(n+m), but still uses additional space. This is because the elements of array nums1 have to be stored somwhere so that they aren't overwritten.

So, what if instead we start to overwrite nums1 from the end, where there is no information yet?

The algorithm is similar to before, except this time we set p1 to point at index m - 1 of nums1, p2 to point at index n - 1 of nums2, and p to point at index m + n - 1 of nums1. This way, it is guaranteed that once we start overwriting the first m values in nums1, we will have already written each into its new position. In this way, we can eliminate the additional space.

Interview Tip: Whenever you're trying to solve an array problem in-place, always consider the possibility of iterating backwards instead of forwards through the array. It can completely change the problem, and make it a lot easier.
 */
public class MergeTwoSortedArraysInOneArray {



public static void main(String[] args) {
// TODO Auto-generated method stub
// int[] nums1 = {1,2,3,0,0,0};
// int[] nums2 = {2,5,6};
int[] nums1 = {0};
int[] nums2 = {1};
merge(nums1, 0, nums2, 1);
//nums1 = nums2;
System.out.println(Arrays.toString(nums1));
}

public static void merge(int[] nums1, int m, int[] nums2, int n) {
       
        if(m == 0) {
    for (int i=0; i< n; i++) {
    	nums1[i] = nums2[i];
    }
            return;
        }
        if (n == 0) {
            return;
        }
        int p1 = m - 1;
        int p2 = n - 1;
        for(int p=m + n - 1; p>=0; p--) {
            if(p2 < 0) {
                break;
            }
            if(p1>= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            }
            else {
                nums1[p] = nums2[p2--];
            }
        }
       
    }
}
