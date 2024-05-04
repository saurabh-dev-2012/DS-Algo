package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

Hint-Reference:
https://www.youtube.com/watch?v=3WocAUICOVU

T: O(n + e) 
    e -  number of edges 

 *
 */
public class CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for(int[] prereq : prerequisites) {
            int to = prereq[0];
            int from = prereq[1];
            ++indegree[to];
            if(!graph.containsKey(from)) {
                graph.put(from, new HashSet<Integer>());
            }
            graph.get(from).add(to);
        }
        
        Queue<Integer> qOrder = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                qOrder.add(i);
            }
        }
        
        int[] courseOrder = new int[numCourses];
        int courseId = 0;
        
        while(!qOrder.isEmpty()) {
            int course = qOrder.poll();
            courseOrder[courseId++] = course;
            for(int next : graph.getOrDefault(course, new HashSet<Integer>())) {
                --indegree[next];
                if(indegree[next] == 0) {
                    qOrder.add(next);
                }
            }
        }
        
        if(courseId != numCourses) {
            return new int[] {};
        }
        
        return courseOrder;
    }

}
