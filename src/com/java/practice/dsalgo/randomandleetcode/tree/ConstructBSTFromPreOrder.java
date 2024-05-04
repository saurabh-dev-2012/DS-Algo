package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.Stack;

/**
 *
 * @author saurabh
 *
 *Input : k = 5  
        Root of below binary tree:
           10
        /     \
      5        14
    /   \     /   \
   4     7   11    15                        
        /   / \     \                    
       6   12  13    16    
 */
public class ConstructBSTFromPreOrder {

public static class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
}
}


// int idx = 0;
// int[] preorder;
// int n;
//
// public TreeNode helper(int lower, int upper) {
//    // if all elements from preorder are used
//    // then the tree is constructed
// if (idx == n) return null;
//
//    int val = preorder[idx];
//    // if the current element
//    // couldn't be placed here to meet BST requirements
//    if (val < lower || val > upper) return null;
//
//    // place the current element
//    // and recursively construct subtrees
//    idx++;
//    TreeNode root = new TreeNode(val);
//    root.left = helper(lower, val);
//    root.right = helper(val, upper);
//    return root;
//  }
//
//  public TreeNode bstFromPreorder2(int[] preorder) {
//    this.preorder = preorder;
//    n = preorder.length;
//    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
//  }

 public static TreeNode bstFromPreorder(int[] preorder) {
   int n = preorder.length;
   if (n == 0) return null;

   TreeNode root = new TreeNode(preorder[0]);
   Stack<TreeNode> stack = new Stack<TreeNode>();
   stack.push(root);

   for (int i = 1; i < n; i++) {
     // take the last element of the deque as a parent
     // and create a child from the next preorder element
     TreeNode node = stack.peek();
     TreeNode child = new TreeNode(preorder[i]);
     // adjust the parent
     while (!stack.isEmpty() && stack.peek().val < child.val)
       node = stack.pop();

     // follow BST logic to create a parent-child link
     if (node.val < child.val) node.right = child;
     else node.left = child;
     // add the child into deque
     stack.push(child);
   }
   return root;
 }


public static void main(String[] args) {
// TODO Auto-generated method stub
int[] preorder = {8,5,1,7,10};
TreeNode bst = bstFromPreorder(preorder);
System.out.println();
}

}