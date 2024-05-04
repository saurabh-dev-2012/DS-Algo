package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class IsBST {

private static Integer prev;
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
prev = null;
//call function from here
TreeNode root = new TreeNode(0);
System.out.println(inorder(root));
}
/**
* Root of below binary tree:
     4
   /   \
 2      6
/  \    
1    5                        
 **/
static boolean inorder(TreeNode root) {
    if (root == null) {
        return true;
    }
    if (!inorder(root.left_ptr)) {
        return false;
    }
    if (prev != null && root.val <= prev) {
        return false;
    }
    prev = root.val;
    return inorder(root.right_ptr);
    }

}
