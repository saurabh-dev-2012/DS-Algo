package com.java.practice.dsalgo.leetcode.dynamicprogramming;
/**
 * 
 * @author saurabh
 *
 *Paint House
Medium

1683

114

Add to List

Share
There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.

 

Example 1:

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.
Example 2:

Input: costs = [[7,6,2]]
Output: 2
 

Constraints:

costs.length == n
costs[i].length == 3
1 <= n <= 100
1 <= costs[i][j] <= 20
Accepted
147,905
Submissions

Hint-Reference:
https://www.youtube.com/watch?v=kh48JLieeW8

 *
 */
public class PaintHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minCost(int[][] costs) {
        
        long[][] dp = new long[costs.length][3];
        
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i=1; i<costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }
        
        return Math.min((int)dp[dp.length - 1][0], 
                        (int)Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
    }

}
