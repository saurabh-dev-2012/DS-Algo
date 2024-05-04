package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.java.practice.dsalgo.ikandleetcode.tree.LowestCommonAncestorOfBST.TreeNode;

/**
 * 
 * @author saurabh
 *
 *
 *Find Leaves of Binary Tree
Medium

2103

38

Add to List

Share
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.
 

Example 1:


Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
Example 2:

Input: root = [1]
Output: [[1]]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

Hint-Reference:
https://www.youtube.com/watch?v=2vwTmHTL1Mk

 */
public class LeavesOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
	
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> allLeaves = new ArrayList<>();
        dfs(root, allLeaves);
        return allLeaves;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> allLeaves) {
        if(root == null) {
            return -1;
        }
        int level = Math.max(dfs(root.left, allLeaves), dfs(root.right, allLeaves)) + 1;
        if(allLeaves.size() <= level) {
            allLeaves.add(new ArrayList<Integer>());
        }
        allLeaves.get(level).add(root.val);
        return level;
    }

}
