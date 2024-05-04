package com.java.practice.dsalgo.ikandleetcode.tree;


/**
 * 
 * @author saurabh
 *
 *Count Complete Tree Nodes
Medium

4859

313

Add to List

Share
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 

Example 1:


Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.

Hint-Reference: 
https://www.youtube.com/watch?v=3FaXv9tIagQ

T: Log^2(N)

 *
 */
public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class TreeNode{
        public int label;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){
            this.left = null;
            this.right = null;
        }

        public TreeNode(int label){
            this.label = label;
            this.left = null;
            this.right = null;
        }
    }
	
    public int countNodes(TreeNode root) {
        int leftHeight = countLeftHeight(root);
        int rightHeight = countRightHeight(root);
        
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        else {
           return 1 + countNodes(root.left) + countNodes(root.right); 
        }
    }
    
    private int countLeftHeight(TreeNode root) {
        return root == null ? 0 : 1 + countLeftHeight(root.left);
    }
    
    private int countRightHeight(TreeNode root) {
        return root == null ? 0 : 1 + countRightHeight(root.right);
    }

}
