package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author saurabh
 *
 *Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

Hint-Reference:
https://www.youtube.com/watch?v=kZfHnsrQcP0

 *
 */
public class MeetingRooms2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] it1, int[] it2) {
                return it1[0] - it2[0];
            }
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] it1, int[] it2) {
                return it1[1] - it2[1];
            }
        });
        
        pq.add(intervals[0]);
        
        for(int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            int[] prev = pq.poll();
            if(curr[0] < prev[1]) {
                pq.add(prev);
                pq.add(curr);
            }
            else {
                prev[1] = curr[1];
                pq.add(prev);
            }
        }
        
        return pq.size();
    }

}
