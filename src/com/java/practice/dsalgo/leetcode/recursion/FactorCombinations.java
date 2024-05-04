package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Factor Combinations
Numbers can be regarded as the product of their factors.

For example, 8 = 2 x 2 x 2 = 2 x 4.
Given an integer n, return all possible combinations of its factors. You may return the answer in any order.

Note that the factors should be in the range [2, n - 1].

 

Example 1:

Input: n = 1
Output: []
Example 2:

Input: n = 12
Output: [[2,6],[3,4],[2,2,3]]
Example 3:

Input: n = 37
Output: []
 

Constraints:

1 <= n <= 107
 *
 */
public class FactorCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> factorCombinations = getFactors(12);
		System.out.println();
	}
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> factorCombos = new ArrayList<>();
        backTrack(n, 2, new LinkedList<Integer>(), factorCombos);
        return factorCombos; 
    }
    
    private static void backTrack(int n, int start, LinkedList<Integer> factComb, 
                          List<List<Integer>> factorCombos) {
        if(n == 1) {
            if(factComb.size() > 1) {
                factorCombos.add(new ArrayList(factComb));
               return;
            }
        }
        for(int i=start; i<=n; i++) {
            if(n % i == 0) {
                factComb.add(i);
                backTrack(n/i, i, factComb, factorCombos);
                factComb.removeLast(); 
            }
        }
    }

}
