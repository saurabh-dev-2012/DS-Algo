package com.java.practice.dsalgo.ikandleetcode.tree;


/**
 *
 * @author saurabh
 *
 *A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

 

Example 1:


Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000


 */
public class MaxPathSumOfBinaryTree {

private static class TreeNode {
   public int val;
   public TreeNode left_ptr;
   public TreeNode right_ptr;

   public TreeNode(){
       this.left_ptr = null;
       this.right_ptr = null;
   }

   public TreeNode(int val){
       this.val = val;
       this.left_ptr = null;
       this.right_ptr = null;
   }
}

public static void main(String[] args) {
// TODO Auto-generated method stub

}

private int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
   
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
       
        int leftSum = Math.max(0, dfs(root.left_ptr));
        int rightSum = Math.max(0, dfs(root.right_ptr));
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
       
        return root.val + Math.max(leftSum, rightSum);
    }

}
