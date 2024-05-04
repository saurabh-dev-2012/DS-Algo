package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.HashSet;

public class MostStonesRemovedWithSameRowColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println("Most stones removed: "+ removeStones(stones));
	}
	
	
    public static int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(stones.length * stones[0].length);
        for(int[] stone: stones){
            ds.union(stone[0], stone[1]+(ds.size/2));
        }
 
        HashSet<Integer> set = new HashSet<>();
        for(int[] stone: stones){
            set.add(ds.find(stone[0]));
        }
 
        return stones.length - set.size();
    }
	 
	static class DisjointSet{
	    int[] parent;
	    int size;
	    public DisjointSet(int size){
	        parent = new int[size];
	        this.size = size;
	        for(int i=0; i<size; i++){
	            parent[i] = i;
	        }
	    }
	 
	    public void union(int i, int j){
	        parent[find(i)] = find(j);
	    }
	 
	    public int find(int i){
	        while(parent[i] != i){
	            i = parent[i];
	        }
	 
	        return i;
	    }
	}
	

}
