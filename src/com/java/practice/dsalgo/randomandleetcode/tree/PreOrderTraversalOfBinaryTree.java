package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;

public class PreOrderTraversalOfBinaryTree {

private static class TreeNode {
   public int label;
   public TreeNode left_ptr;
   public TreeNode right_ptr;

   public TreeNode(){
       this.left_ptr = null;
       this.right_ptr = null;
   }

   public TreeNode(int val){
       this.label = val;
       this.left_ptr = null;
       this.right_ptr = null;
   }
}

public static void main(String[] args) {
// TODO Auto-generated method stub

}

static ArrayList<Integer> preorder(TreeNode root) {

        ArrayList<Integer> preOrder = new ArrayList<>();
        if(root == null) {
            return preOrder;
        }
        return preorderTraversal(root, preOrder);
       
    }
   
    private static ArrayList<Integer> preorderTraversal(TreeNode root, ArrayList<Integer> preOrder) {
       
        preOrder.add(root.label);
       
        if(root.left_ptr != null) {
            preOrder = preorderTraversal(root.left_ptr, new ArrayList<Integer>(preOrder));
        }
        if(root.right_ptr != null) {
            preOrder = preorderTraversal(root.right_ptr, new ArrayList<Integer>(preOrder));
        }
       
        return preOrder;
    }

}