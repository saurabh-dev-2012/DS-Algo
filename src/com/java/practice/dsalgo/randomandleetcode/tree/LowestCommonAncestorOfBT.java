package com.java.practice.dsalgo.ikandleetcode.tree;

/**
 *
 * @author saurabh
 *
 *Least Common Ancestor

Find the lowest common ancestor (LCA) of two nodes in a binary tree of n nodes.
Given references to the root node and nodes a and b of the tree, return the value from the LCA node of a and b.

The LCA of nodes a and b in a tree is defined as the shared ancestor node of a and b that is located farthest from
the root.

Root of below binary tree:
          1
        /   \
      2      3
    /  \    / \
   4    5  6   7                        
       / \                          
      8   9        

Output: LCA(8, 9)=5

There are three shared parents of 8 and 9 in this tree: 5, 2, 1. Of those three,
the farthest from the root is 5.

Other examples:

LCA(2,5) = 2

LCA(2,3) = 1


Hint-Reference: 
https://www.youtube.com/watch?v=WRAJ8Q9bICM

 */

public class LowestCommonAncestorOfBT {

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

    static int lca = Integer.MIN_VALUE;
    int lca(TreeNode head, TreeNode a, TreeNode b)
    {
        recurseTree(head, a, b);
        return lca;
    }
    
  /**  Root of below binary tree:
        1
      /   \
    2      3
  /  \    / \
 4    5  6   7                        
     / \                          
    8   9    
    
  **/    
   
    // Simple Hint-Reference
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // recurseTree(root, p, q);
        // return lca;
        if(root == null) {
            return root;
        }
        
        if(root.equals(p) || root.equals(q)) {
            return root;
        }
        
        TreeNode leftNode = lowestCommonAncestor(root.left_ptr, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right_ptr, p, q);
        
        if(leftNode != null && rightNode != null) {
            return root;
        }
        
        if(leftNode != null) {
            return leftNode;
        }
        else {
            return rightNode;
        }
        
    }
    
    
	private static boolean recurseTree(TreeNode head, TreeNode a, TreeNode b) {
	   
        if(head == null) {
            return false;
        }
       
	    // integer to determine if we found a or b in left subtree
	    int left = recurseTree(head.left_ptr, a, b) ? 1 : 0;
	   
	    // integer to determine if we found a or b in right subtree
	    int right = recurseTree(head.right_ptr, a, b) ? 1 : 0;
	   
	    // integer to determine if we found a or b anywhere
	    int mid = (head == a || head == b) ? 1 : 0;
	   
	    if(left + right + mid >= 2) {
	        lca = head.val;
	    }
	   
	    return (left + right + mid) > 0;
	}

}
