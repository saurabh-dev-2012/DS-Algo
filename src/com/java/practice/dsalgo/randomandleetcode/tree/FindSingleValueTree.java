package com.java.practice.dsalgo.ikandleetcode.tree;

/*
 * Single Value Tree

Given a binary tree, find the number of unival subtrees. An unival tree is a tree that has the same value in every node.

Example One

Input:

../../../../Desktop/Screen%20Shot%202019-06-26%20at%2010.48.5

Output: 6

The input tree has a total of 6 nodes. Each node is a root of a subtree. All those 6 subtrees are unival trees.

Example Two

Input:

../../../Desktop/Screen%20Shot%202019-06-25%20at%2011.11.55%2

Output: 5

The input tree has a total of 7 nodes, so there are 7 subtrees. Of those 7, all but two subtrees are unival. The two non-unival subtrees are:

the one rooted in the root node and
the one rooted in the root’s right child.

 */

public class FindSingleValueTree {

private static class TreeNode{
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

    // MAP TO STORE FREQUENCIES OF NODE VALUES
    private static class Count {
        int count = 0;
    }
    static int findSingleValueTrees(TreeNode root) {
        Count c = new Count();
        singleValuedTrees(root,c);
        return c.count;
    }
   
    private static boolean singleValuedTrees(TreeNode root, Count c) {
       
        if(root == null)
            return true;
           
        boolean left = singleValuedTrees(root.left_ptr, c);
        boolean right = singleValuedTrees(root.right_ptr, c);
       
        if(left == false || right == false) {
            return false;
        }
       
        if(root.left_ptr != null && root.val != root.left_ptr.val) {
            return false;
        }
       
        if(root.right_ptr != null && root.val != root.right_ptr.val) {
            return false;
        }
       
        c.count++;
        return true;
    }

}
