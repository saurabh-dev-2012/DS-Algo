package com.java.practice.dsalgo.ikandleetcode.tree;


/**
 *
 * @author saurabh
 *
 * Flatten Binary Tree to Linked List
Medium

6099

439

Add to List

Share
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?

 *
 * Hint-Reference: https://www.youtube.com/watch?v=NOKVBiJwkD0
 */
public class FlattenBTToLinkedList {

private static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(){
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    public void flatten(TreeNode root) {
        // O(1) space
        if(root == null) {
            return;
        }
       
        while(root != null) {
            if(root.left != null) {
                TreeNode left = root.left;
                TreeNode current = root.left;
                while(current.right != null) {
                    current = current.right;
                }
                current.right = root.right; // Morris Traversal
                root.left = null;
                root.right = left;
            }
            root = root.right;
        }
       
    }

}
