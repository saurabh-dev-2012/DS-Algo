package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author saurabh
 *
 *Merge Intervals
Medium

11687

476

Add to List

Share
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

Hint-Reference:
https://www.youtube.com/watch?v=bom4wItgkt0
 */
public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//intervals = [[1,3],[2,6],[8,10],[15,18]]
		int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		System.out.println(Arrays.toString(merge(intervals)));
	}
	
	 static class Interval {
	        int start;
	        int end;
	        public Interval(int s, int e) {
	            this.start = s;
	            this.end = e;
	        }
	    }
	    
	    public static int[][] merge(int[][] intervals) {
	        if(intervals == null || intervals.length <= 1) {
	            return intervals;
	        }
	        List<Interval> intervalList = new LinkedList<>();
	        // populate interval list
	        for(int[] interval : intervals) {
	            intervalList.add(new Interval(interval[0], interval[1]));
	        }
	        
	        // sort intervals by start
	        Collections.sort(intervalList, new Comparator<Interval>() {
	           public int compare(Interval i1, Interval i2) {
	               return i1.start - i2.start;
	           } 
	        });
	        
	        // merge intervals
	        LinkedList<Interval> mergedIntervals = new LinkedList<Interval>();
	        for(Interval ival : intervalList) {
	            
	            if(mergedIntervals.isEmpty() || mergedIntervals.getLast().end < ival.start) {
	                mergedIntervals.add(ival);
	            }
	            else {
	                mergedIntervals.getLast().end = Math.max(mergedIntervals.getLast().end, ival.end);
	            }
	        }
	        
	        int[][] mergedResult = new int[mergedIntervals.size()][2];
	        int count = 0;
	        for(Interval iVal : mergedIntervals) {
	            mergedResult[count][0] = iVal.start;
	            mergedResult[count][1] = iVal.end;
	            count++;
	        }
	        
	        return mergedResult;
	    }

}
