package com.java.practice.dsalgo.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author saurabh
 *
 *You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

Hint-Reference:

https://www.youtube.com/watch?v=yQa2VSDhxA0
 *
 */
public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        
        //fill minimum no of ways to make up amount = index of dp array into that index of array
        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {
                // only update amounts in dp array for coins which exists in coins array
                // "i" represents the amount to make up using "coin" denomination in this case
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        // check overflow
        return dp[amount] > amount ? -1 : dp[amount];
        
    }

}
