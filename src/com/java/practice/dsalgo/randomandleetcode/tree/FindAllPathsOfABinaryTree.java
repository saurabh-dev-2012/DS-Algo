package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author saurabh
 *
 * Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6
 *
 */
public class FindAllPathsOfABinaryTree {

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
            path.add(root.val);
       
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

}