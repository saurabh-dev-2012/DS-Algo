package com.java.practice.dsalgo.leetcode.dynamicprogramming;
/**
 * 
 * @author saurabh
 *
 *Paint House II
Hard

925

32

Add to List

Share
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x k cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
Return the minimum cost to paint all houses.

 

Example 1:

Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation:
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Example 2:

Input: costs = [[1,3],[2,4]]
Output: 5
 

Constraints:

costs.length == n
costs[i].length == k
1 <= n <= 100
2 <= k <= 20
1 <= costs[i][j] <= 20
 

Follow up: Could you solve it in O(nk) runtime?

Hint-Reference:
https://www.youtube.com/watch?v=jGywRalvoRw

 *
 */
public class PaintHouse2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minCostII(int[][] costs) {
        
        int row = costs.length;
        int col = costs[0].length;
        int[][] dp = new int[row][col];
        
        int least = Integer.MAX_VALUE;
        int sLeast = Integer.MAX_VALUE;
      
        // store first row cost in dp array
        for(int i=0; i<col; i++) {
            dp[0][i] = costs[0][i];
            
            if(dp[0][i] <= least) {
                sLeast = least;
                least = dp[0][i];
            }
            else if(dp[0][i] <= sLeast) {
                sLeast  = dp[0][i];
            }
        }
             
        // fill dp array with min costs
        for(int i=1; i<row; i++) {
            int nLeast = Integer.MAX_VALUE;
            int nSLeast = Integer.MAX_VALUE;
            for(int j=0; j<col; j++) {
                if(least == dp[i-1][j]) {
                    dp[i][j] = sLeast + costs[i][j];
                }
                else {
                    dp[i][j] = least + costs[i][j];
                }
                
                // update new least and second least
                if(dp[i][j] <= nLeast) {
                    nSLeast = nLeast;
                    nLeast = dp[i][j];
                }
                else if(dp[i][j] <= nSLeast) {
                    nSLeast  = dp[i][j];
                }
            }
            least = nLeast;
            sLeast = nSLeast;
        }
        
        return least;
    }

}
