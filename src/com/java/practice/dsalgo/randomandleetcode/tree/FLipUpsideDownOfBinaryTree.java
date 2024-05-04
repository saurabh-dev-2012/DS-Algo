package com.java.practice.dsalgo.ikandleetcode.tree;


/**
 *
 * @author saurabh
 *Upside Down

Given a binary tree where every node has either 0 or 2 children and every right node is a leaf node,
flip it upside down turning it into a binary tree where all left nodes are leafs.
 */

public class FLipUpsideDownOfBinaryTree {

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
TreeNode root = new TreeNode(1);
        root.left_ptr = new TreeNode(2);
        root.right_ptr = new TreeNode(3);
        root.left_ptr.left_ptr = new TreeNode(4);
        root.left_ptr.right_ptr = new TreeNode(5);
        root.left_ptr.left_ptr.left_ptr = new TreeNode(6);
        root.left_ptr.left_ptr.right_ptr = new TreeNode(7);
        TreeNode upsideDown = flipUpsideDown(root);
        System.out.println();
}

    static TreeNode flipUpsideDown(TreeNode root) {
       
        if(root == null || root.left_ptr == null) {
            return root;
        }
        TreeNode newRoot = flipUpsideDown(root.left_ptr);
        root.left_ptr.left_ptr = root.right_ptr;
        root.left_ptr.right_ptr = root;
        root.left_ptr = null;
        root.right_ptr = null;
       
        return newRoot;
    }

}
