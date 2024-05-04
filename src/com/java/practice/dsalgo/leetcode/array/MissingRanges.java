package com.java.practice.dsalgo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Missing Ranges
Easy

778

2523

Add to List

Share
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]
Explanation: The ranges are:
[2,2] --> "2"
[4,49] --> "4->49"
[51,74] --> "51->74"
[76,99] --> "76->99"
Example 2:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
 

Constraints:

-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.

Hint-Reference:
https://www.youtube.com/watch?v=eWBk78uVEbU

O(n)
 *
 */
public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            addRanges(lower, upper, missingRanges);
            return missingRanges;
        }
        int start = lower;
        for(int end : nums) {
            if(start < end) {
                addRanges(start, end - 1, missingRanges);
            }
            start = end + 1;
        }
        
        if(start <= upper) {
            addRanges(start, upper, missingRanges);
        }
        
        return missingRanges;
        
    }
    
    private void addRanges(int lower, int upper, List<String> ranges) {
        if(lower == upper) {
            ranges.add(Integer.toString(lower));
        }
        else {
            ranges.add(Integer.toString(lower) + "->" + Integer.toString(upper));
        }
    }

}
