package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 

Example 1:

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Example 2:

Input: nums = [-1]
Output: [0]
Example 3:

Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

Hint-Reference:

https://www.youtube.com/watch?v=buDoT9ESw1c

T: O(n)
 *
 */
public class CountSmallerNumberAfterSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Hint-Reference {
	    public List<Integer> countSmaller(int[] nums) {
	        List<Integer> ans = new ArrayList<>();
	        if(nums == null || nums.length == 0) {
	            return ans;
	        }
	        int n = nums.length;
	        
	        boolean isAscendingArrray = true;
	        for(int i = 0; i < nums.length-1; i++) {
	            if(nums[i] > nums[i+1]) {
	                isAscendingArrray = false;
	                break;
	            }
	        }

	        if(isAscendingArrray) {
	            List<Integer> list = new ArrayList<>();
	            for(int i = 0; i < nums.length; i++) {
	                list.add(0);
	            }
	            return list;
	        }
	 
	        
	        boolean isdecendingArrray = true;
	        for(int i = 0; i < nums.length-1; i++) {
	            if(!(nums[i] >= nums[i+1])) {
	                isdecendingArrray = false;
	                break;
	            }
	        }
	        int diffCount = 0;
	        int repeatCount = 0;
	        if(isdecendingArrray) {
	            List<Integer> list = new ArrayList<>();
	            list.add(0);
	            for(int i = nums.length-2; i >= 0 ; i--) {
	                if(nums[i] > nums[i+1]) {
	                    diffCount += repeatCount;
	                    list.add(++diffCount);
	                    repeatCount = 0;
	                } else {
	                    list.add(diffCount);
	                    repeatCount++;
	                }
	            }
	            Collections.reverse(list);
	            return list;
	        }
	        
	        TreeNode root = new TreeNode(nums[n-1]);
	        ans.add(0);
	        for(int i=n-2; i>=0; i--) {
	            int count = insertNode(root, nums[i]);
	            ans.add(count);
	        }
	        Collections.reverse(ans);
	        return ans;
	    }
	    
	    
	    class TreeNode {
	        TreeNode right;
	        TreeNode left;
	        int data;
	        int count = 1;
	        
	        public TreeNode(int data) {
	            this.data = data;
	        }
	    }
	    
	    private int insertNode(TreeNode root, int val) {
	        TreeNode temp = new TreeNode(val);
	        int result = 0;
	        boolean isConnected = false;
	        
	        while(!isConnected) {
	            if(temp.data <= root.data) {
	                root.count++;
	                if(root.left == null) {
	                    root.left = temp;
	                    isConnected = true;
	                }
	                else {
	                    root = root.left;
	                }
	            }
	            else {   
	                result += root.count;
	                if(root.right == null) {
	                    root.right = temp;
	                    isConnected = true;
	                }
	                else {
	                    root = root.right;
	                }
	            }
	        }
	        return result;
	    }
	}

}
