package com.java.practice.dsalgo.ikandleetcode.tree;

/**
 *
 * @author saurabh
 *
 * Notes: Diameter of a binary tree is the length of the longest path between any two nodes of the tree.
 * Length between any two nodes is equal to the number of edges traversed to reach one node from the other.
 *       1
 *      / \
 *     2   3
 *    / \
 *   4   5
 */

public class DiameterOfBinaryTree {

private static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(){
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int label){
            this.label = label;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    static Integer diameter = 0;
    static Integer binary_tree_diameter(TreeNode root) {
        //Idea is to calculate left side of the tree's height & right side of the tree's height
        // return the sum as diameter
        dfs(root);
        return diameter;
    }
   
    /**
     *   1
 *      / \
 *     2   3
 *    / \
 *   4   5
 *  
     * @param root
     * @return
     */
   
    private static Integer dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left_ptr);
        int rightHeight = dfs(root.right_ptr);
       
        diameter = Math.max(diameter, leftHeight + rightHeight);
       
        return Math.max(leftHeight, rightHeight) + 1;
    }

}