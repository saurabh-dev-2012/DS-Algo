package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Course Schedule
Medium

8541

334

Add to List

Share
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

Hint-Reference:
https://www.youtube.com/watch?v=CL4NZAoOdpM
 *
 */
public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] explored;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        
        //initialize adj list
        for(int i=0; i<numCourses; i++) {
          adj[i] = new ArrayList<>();  
        }
        
        // Generate graph
        for(int i=0; i<prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        // dfs
        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(isCyclic(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isCyclic(int i) {
        visited[i] = true;
        for(int j : adj[i]) {
            if(!visited[j]) {
                if(isCyclic(j)) {
                    return true;
                }
            }
            else if(!explored[j]) {
                return true;
            }
        }
        explored[i] = true;
        return false;
    }

}
