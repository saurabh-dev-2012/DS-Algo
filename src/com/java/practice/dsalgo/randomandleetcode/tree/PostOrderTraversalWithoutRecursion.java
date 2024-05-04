package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {

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

    static List<Integer> postorder_traversal(TreeNode root) {
        // Hint-Reference 1 with stack
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }
        // LIFO structure
        Stack<TreeNode> stack = new Stack<>();
        // Start with root value as it is the last to pop out from stack
        stack.push(root);
       
        while(!stack.isEmpty()) {
            // do not pop
            TreeNode current = stack.peek();
           
            if(isLeaf(current)) {
                TreeNode leaf = stack.pop();
                postOrder.add(leaf.val);
            } else {
                if(current.right_ptr != null) {
                    stack.push(current.right_ptr);
                    current.right_ptr = null;
                }
                if (current.left_ptr != null) {
                     stack.push(current.left_ptr);
                     current.left_ptr = null;
                }
            }
        }
       
        return postOrder;
    }
   
    private static boolean isLeaf(TreeNode node) {
       
        return node.left_ptr == null ? node.right_ptr == null : false;
    }

}