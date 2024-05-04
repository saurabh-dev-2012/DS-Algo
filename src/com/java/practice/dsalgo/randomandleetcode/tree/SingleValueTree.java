package com.java.practice.dsalgo.ikandleetcode.tree;

/**
 *
 * @author saurabh
 *
 *Single Value Tree:

Given a binary tree, find the number of unival subtrees. An unival tree is a tree that has the same value in every node.
 */
public class SingleValueTree {

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
       
        if(root.left_ptr != null && root.label != root.left_ptr.label) {
            return false;
        }
       
        if(root.right_ptr != null && root.label != root.right_ptr.label) {
            return false;
        }
       
        c.count++;
        return true;
    }

public static void main(String[] args) {
// TODO Auto-generated method stub

}

}

