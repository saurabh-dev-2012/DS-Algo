package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author saurabh
 *
 *Print All Paths Of A Tree

Given a binary tree, return all paths from root to leaf.


 */

public class PrintAllPathsOfABinaryTree {

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

static List<List<Integer>> allPathsOfABinaryTree(TreeNode root) {
       
        if (root == null) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        preOrderTraversal(root, new ArrayList<Integer>(), resultList);
        return resultList;
    }
   
    private static void preOrderTraversal(TreeNode root, List<Integer> path, List<List<Integer>> resultList) {
       
        if(root != null) {
            path.add(root.label);
       
            if(root.left_ptr == null && root.right_ptr == null) {
                resultList.add(new ArrayList<Integer>(path));
            }
            else {
                // List<Integer> newPath = new ArrayList();
                // newPath.addAll(path);
                preOrderTraversal(root.left_ptr, new ArrayList<Integer>(path), resultList);
                preOrderTraversal(root.right_ptr, new ArrayList<Integer>(path), resultList);
            }
        }
    }

public static void main(String[] args) {
// TODO Auto-generated method stub

}

}