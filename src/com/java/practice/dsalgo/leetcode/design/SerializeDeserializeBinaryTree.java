package com.java.practice.dsalgo.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author saurabh
 *
 *Serialize and Deserialize Binary Tree
Hard

5894

232

Add to List

Share
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000

Hint-Reference: 
https://www.youtube.com/watch?v=f-OjjxWycZE
 */
public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for a binary tree node.
	 * */
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	        if(root == null) {
	            return "|";
	        }
	        String leftSubTree = serialize(root.left);
	        String rightSubTree = serialize(root.right);
	        return root.val + "," + leftSubTree + "," + rightSubTree;
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] nodes = data.split(",");
	        Queue<String> preQueue = new LinkedList<>();
	        for(String node : nodes) {
	            preQueue.add(node);
	        }
	        return deserialize(preQueue);
	    }
	    
	    private TreeNode deserialize(Queue<String> preQueue) {
	        if(preQueue.size() == 0) {
	            return null;
	        }
	        String peek = preQueue.poll(); 
	        if(peek.equals("|")) {
	            return null;
	        }
	        // construct tree
	        TreeNode root = new TreeNode(Integer.parseInt(peek));
	        root.left = deserialize(preQueue);
	        root.right = deserialize(preQueue);
	        
	        return root;
	    } 
	}

	// Your Codec object will be instantiated and called as such:
	// Codec ser = new Codec();
	// Codec deser = new Codec();
	// TreeNode ans = deser.deserialize(ser.serialize(root));

}
