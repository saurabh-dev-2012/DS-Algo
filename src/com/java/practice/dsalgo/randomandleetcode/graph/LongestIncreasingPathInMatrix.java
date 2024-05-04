package com.java.practice.dsalgo.ikandleetcode.graph;
/**
 * 
 * @author saurabh
 *
 *Longest Increasing Path in a Matrix
Hard

5288

90

Add to List

Share
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

Hint-Reference:
https://www.youtube.com/watch?v=uLjO2LUlLN4

T: O(n * m)
S: O(n * m)
 *
 */
public class LongestIncreasingPathInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    int[][] DIRECTIONS = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, longestPath = 0;
        int[][] cache = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int longest = longestIncreasingPath(matrix, cache, i, j, n, m);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }
    
    private int longestIncreasingPath(int[][] matrix, int[][] cache, int i, int j, 
                                      int n, int m) {
        if(cache[i][j] > 0) {
            return cache[i][j];
        }
        int max = 0;
        for(int[] direction : DIRECTIONS) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            if(x > -1 && y > -1 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                int longest = longestIncreasingPath(matrix, cache, x, y, n, m);
                max = Math.max(max, longest);
            }
        }
        
        cache[i][j] = max + 1;
        
        return cache[i][j];
    }

}
