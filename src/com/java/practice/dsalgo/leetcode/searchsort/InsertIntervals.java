package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *
 *Insert Interval
Medium

4800

340

Add to List

Share
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105

Hint-Reference:
https://www.youtube.com/watch?v=4HztxU15xr0

T: O(n)
S: O(n)

 */
public class InsertIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        
        // safe intervals
        while(i<len && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        
        // merge intervals
        while(i<len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
         ans.add(newInterval);
        
        // remaining if any
        while(i<len) {
            ans.add(intervals[i]);
            i++;
        }
        
        int[][] result = new int[ans.size()][2];
        
        for(int j=0; j<ans.size(); j++) {
            result[j] = ans.get(j);
        }
        
        return result;
    }

}
