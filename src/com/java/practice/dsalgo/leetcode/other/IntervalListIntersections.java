package com.java.practice.dsalgo.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *
 *Interval List Intersections
Medium

3779

80

Add to List

Share
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 

Example 1:


Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:

Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
 

Constraints:

0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109
endj < startj+1

Hint-Reference: 
https://www.youtube.com/watch?v=EsuaXBQh4hs
 */
public class IntervalListIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        if(firstList == null || firstList.length == 0 || secondList == null ||
          secondList.length == 0) {
            return new int[0][0];
        }
        
        int i=0, j=0;
        List<int[]> intersectionList = new ArrayList<>();
        while(i < firstList.length && j < secondList.length) {
            int max = Math.max(firstList[i][0], secondList[j][0]);
            int min = Math.min(firstList[i][1], secondList[j][1]);
            
            if(max <= min) {
                intersectionList.add(new int[] {max, min});
            }
            
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        int[][] intersectionArr = new int[intersectionList.size()][2];
        for(int k=0; k<intersectionList.size(); k++) {
            intersectionArr[k] = intersectionList.get(k);
        }
        
        return intersectionArr;
    }

}
