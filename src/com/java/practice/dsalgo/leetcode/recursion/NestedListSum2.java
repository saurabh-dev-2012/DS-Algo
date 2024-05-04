package com.java.practice.dsalgo.leetcode.recursion;
/**
 * 
 * @author saurabh
 *
 *
 *You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.

The weight of an integer is maxDepth - (the depth of the integer) + 1.

Return the sum of each integer in nestedList multiplied by its weight.

 

Example 1:


Input: nestedList = [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
Example 2:


Input: nestedList = [1,[4,[6]]]
Output: 17
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
1*3 + 4*2 + 6*1 = 17
 

Constraints:

1 <= nestedList.length <= 50
The values of the integers in the nested list is in the range [-100, 100].
The maximum depth of any integer is less than or equal to 50.

 */
public class NestedListSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class WeightedSum {
	    int maxDepth;
	    int sumOfElements;
	    int productOfElements;

	    public WeightedSum(int maxDepth, int sumOfElements, int productOfElements) {
	        this.maxDepth = maxDepth;
	        this.sumOfElements = sumOfElements;
	        this.productOfElements = productOfElements;
	    }
	}
	
//	public int depthSumInverse(List<NestedInteger> nestedList) {
//        WeightedSum result = dfs(nestedList, 1);
//        return (result.maxDepth + 1) * result.sumOfElements - result.productOfElements;
//    }
//    
//    private WeightedSum dfs(List<NestedInteger> nestedList, int depth) {
//        int maxDepth = 0;
//        int sumOfElements = 0;
//        int productOfElements = 0;
//        
//        for(NestedInteger integer : nestedList) {
//            if(integer.isInteger()) {
//                productOfElements += integer.getInteger() * depth;
//                sumOfElements += integer.getInteger();
//                maxDepth = Math.max(maxDepth, depth);
//            }
//            else {
//                WeightedSum result = dfs(integer.getList(), depth + 1);
//                maxDepth = Math.max(maxDepth, result.maxDepth);
//                sumOfElements += result.sumOfElements;
//                productOfElements += result.productOfElements;
//            }
//        }
//        return new WeightedSum(maxDepth, sumOfElements, productOfElements);
//    }

}
