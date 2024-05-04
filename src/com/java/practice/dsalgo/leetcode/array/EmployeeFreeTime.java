package com.java.practice.dsalgo.leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author saurabh
 *
 *Employee Free Time
Hard

1420

91

Add to List

Share
We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.

 

Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]
 

Constraints:

1 <= schedule.length , schedule[i].length <= 50
0 <= schedule[i].start < schedule[i].end <= 10^8

Hint-Reference:
https://www.youtube.com/watch?v=1-A2aMl4I68

T: O(n * logk) k - number of items in priority queue
S: O(logk)

 *
 */
public class EmployeeFreeTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Interval {
	    public int start;
	    public int end;

	    public Interval() {}

	    public Interval(int _start, int _end) {
	        start = _start;
	        end = _end;
	    }
	}
	
	class EmployeeInterval {
	    Interval interval;
	    int employeeIndex;
	    int intervalIndex;
	    
	    public EmployeeInterval(Interval intval, int eIndex, int iIndex) {
	        interval = intval;
	        employeeIndex = eIndex;
	        intervalIndex = iIndex;
	    }
	}
	
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        PriorityQueue<EmployeeInterval> pq = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);
        List<Interval> freeTimes = new ArrayList<>();
        
        for(int i=0; i<schedule.size(); i++) {
            pq.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }
        
        Interval prevInterval = pq.peek().interval;
        
        while(!pq.isEmpty()) {
            EmployeeInterval topItem = pq.poll();
            
            if(prevInterval.end < topItem.interval.start) {
                // No overlap
                freeTimes.add(new Interval(prevInterval.end, topItem.interval.start));
                prevInterval = topItem.interval;
            }
            else if (prevInterval.end < topItem.interval.end) {
                // overlap
                prevInterval = topItem.interval;
            }
            
            List<Interval> empSchedule = schedule.get(topItem.employeeIndex);
            if(empSchedule.size() > topItem.intervalIndex + 1) {
                pq.offer(new EmployeeInterval(empSchedule.get(topItem.intervalIndex + 1), topItem.employeeIndex, topItem.intervalIndex + 1));
            }
        }
        
        return freeTimes;
        
    }

}
