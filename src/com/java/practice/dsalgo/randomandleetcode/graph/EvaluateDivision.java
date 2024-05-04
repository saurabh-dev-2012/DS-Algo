package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *Evaluate Division
Medium

5746

477

Add to List

Share
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.

Hint-Reference:
https://www.youtube.com/watch?v=UcDZM6Ap5P4

T: O(n)
S: O(n)
 *
 */
public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class Node {
        String key;
        double val;
        
        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Set<Node>> graph = buildGraph(equations, values);
        
        double[] Hint-References = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            Hint-References[i] = dfs(query.get(0), query.get(1), new HashSet<String>(), graph);
        }
        
        return Hint-References;
        
        
    }
    
    private Map<String, Set<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Set<Node>> graph = new HashMap<>();
        
        for(int i=0; i<values.length; i++) {
            String src = equations.get(i).get(0);
            String des = equations.get(i).get(1);
            
            graph.putIfAbsent(src, new HashSet<Node>());
            graph.putIfAbsent(des, new HashSet<Node>());
            
            graph.get(src).add(new Node(des, values[i]));
            graph.get(des).add(new Node(src, 1/values[i]));
        }
        
        return graph;
    }
    
    private double dfs(String src, String des, Set<String> visited, Map<String, Set<Node>> graph)     {
        if(!(graph.containsKey(src) && graph.containsKey(des))) {
            return -1.0;
        }    
        if(src.equals(des)) {
            return 1.0;
        }
        
        visited.add(src);
        for(Node n : graph.get(src)) {
            if(!visited.contains(n.key)) {
                double ans = dfs(n.key, des, visited, graph);
                if(ans != -1) {
                    ans = ans * n.val;
                    return ans;
                }
            }
        }
        
        return -1.0;
    }

}
