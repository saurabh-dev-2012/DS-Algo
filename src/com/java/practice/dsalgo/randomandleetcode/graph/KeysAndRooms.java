package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeysAndRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [[1,3],[3,0,1],[2],[0]]
		List<List<Integer>> rooms = Arrays.asList(
					Arrays.asList(1,3),
					Arrays.asList(3,0,1),
					Arrays.asList(2),
					Arrays.asList(0)
				);
		System.out.println(canVisitAllRooms(rooms));
	}
	
    private static Set<Integer> KEYS = new HashSet<>();
    private static int ROOMS = 0;
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        
        // initialize graph
        int n = rooms.size();
        ROOMS = n;
        KEYS.add(0);
        for(int i=0; i<n; i++) {
            graph.putIfAbsent(i, new HashSet<>());
            graph.get(i).addAll(rooms.get(i));
        }

        boolean[] visited = new boolean[n];
        // 1. DFS
        dfs(graph, visited, 0);
        

        for(boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(Map<Integer,Set<Integer>> graph, boolean[] visited, int room) {
        
        visited[room] = true;
        Set<Integer> keySet = graph.getOrDefault(room, new HashSet<>());
        KEYS.addAll(keySet);
        if(room+1 < ROOMS && !visited[room+1] && KEYS.contains(room+1)) {
            dfs(graph, visited, room+1);
        }
    }

}
