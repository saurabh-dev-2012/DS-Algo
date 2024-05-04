package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Closest Binary Search Tree Value II
Hard

988

32

Add to List

Share
Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.

You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

 

Example 1:


Input: root = [4,2,5,1,3], target = 3.714286, k = 2
Output: [4,3]
Example 2:

Input: root = [1], target = 0.000000, k = 1
Output: [1]
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104.
0 <= Node.val <= 109
-109 <= target <= 109
 

Follow up: Assume that the BST is balanced. Could you solve it in less than O(n) runtime (where n = total nodes)?

Hint-Reference:

https://www.youtube.com/watch?v=3GN3DaJv9_g

 *
 */
public class ClosestBinarySearchTreeValue2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
	
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> kValues = new LinkedList<>();
        inorder(root, target, k, kValues);
        return kValues;
    }
    
    private void inorder(TreeNode root, double target, int k, LinkedList<Integer> kValues) {
        if(root == null) {
            return;
        }
        inorder(root.left, target, k, kValues);
        if(kValues.size() == k) {
            if(Math.abs(target - root.val) < Math.abs(target - kValues.peek())) {
                kValues.remove();
            }
            else {
                return;
            }
        }
        kValues.add(root.val);
        inorder(root.right, target, k, kValues);
    }

}
