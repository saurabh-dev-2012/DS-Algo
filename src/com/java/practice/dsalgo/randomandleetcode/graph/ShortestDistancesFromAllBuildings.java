package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancesFromAllBuildings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private class Position {
        int row;
        int col;
        int distance;
        
        public Position(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        if(!possible(grid)) {
            return -1;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] shortestDistances = new int[row][col];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 1) {
                    int[][] shortestDistancesPos = getShortestDistance(grid, i, j);
                    addDistances(grid, shortestDistances, shortestDistancesPos);
                }
            }
        }
        
        int shortestDistance = Integer.MAX_VALUE;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                shortestDistance = Math.min(shortestDistance, shortestDistances[i][j]);
            }
        }
        
        // print final array for shortest distances
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(shortestDistances[i][j] + " ");
            }
            System.out.println();
        }
        
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
        
    }
    
    private boolean possible(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private int[][] getShortestDistance(int[][] grid, int iPos, int jPos) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] shortestDistances = new int[row][col];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                shortestDistances[i][j] = -1;
            }
        }
        
       // shortestDistances[iPos][jPos] = 0;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(iPos, jPos, 0));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0; k<size; k++) {
                Position pos = queue.poll();
                
                if((grid[pos.row][pos.col] == 2 || grid[pos.row][pos.col] == 1) && !(pos.row == iPos && pos.col == jPos)) {
                    continue;
                }
                
                if(shortestDistances[pos.row][pos.col] != -1) {
                    continue;
                }
                
                shortestDistances[pos.row][pos.col] = pos.distance;
                
                if(pos.row > 0) {
                    queue.add(new Position(pos.row - 1, pos.col, pos.distance + 1));
                }
                if(pos.col > 0) {
                    queue.add(new Position(pos.row, pos.col - 1, pos.distance + 1));
                }
                if(pos.row < (row - 1)) {
                    queue.add(new Position(pos.row + 1, pos.col, pos.distance + 1));
                }
                if(pos.col < (col - 1)) {
                    queue.add(new Position(pos.row, pos.col + 1, pos.distance + 1));
                }
            }
        }
        
        return shortestDistances;
        
    }
    
    private void addDistances(int[][] grid, int[][] shortestDistances, int[][] shortestDistancesPos) {
        int row = grid.length;
        int col = grid[0].length;
        
        System.out.println("In Add Distances Before Executing: ");
        System.out.println("Printing for shortestDistancesPos: ");
        System.out.println();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(shortestDistancesPos[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 2 || grid[i][j] == 1) {
                    shortestDistances[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if(shortestDistancesPos[i][j] == -1) {
                    shortestDistances[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if(shortestDistances[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                shortestDistances[i][j] += shortestDistancesPos[i][j];
            }
        }
        
        // print final array for shortest distances
        System.out.println("In Add Distances After Executing: ");
        System.out.println("Printing for shortestDistances: ");
        System.out.println();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                System.out.print(shortestDistances[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
