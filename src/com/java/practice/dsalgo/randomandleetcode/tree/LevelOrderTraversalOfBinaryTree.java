package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalOfBinaryTree {

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

	// 1 queue Hint-Reference

	public List<List<Integer>> levelOrder(TreeNode root) {
	    List<List<Integer>> levelOrder = new ArrayList<>();
	    if(root == null) {
	        return levelOrder;
	    }
	    
	    Queue<TreeNode> levelQueue = new LinkedList<>();
	    levelQueue.add(root);
	    
	    while(!levelQueue.isEmpty()) {
	        
	        List<Integer> level = new ArrayList<>();
	        int n = levelQueue.size();
	        for(int i=0; i<n; i++) {
	            
	            TreeNode node = levelQueue.remove();
	            level.add(node.val);
	            
	            if(node.left_ptr != null) {
	                levelQueue.add(node.left_ptr);
	            }
	            if(node.right_ptr != null) {
	                levelQueue.add(node.right_ptr);
	            }
	        }
	        
	        levelOrder.add(level);
	    }
	    
	    return levelOrder;
	}
	
	// 2 queue Hint-Reference

    public static List<List<Integer>> level_order_traversal(TreeNode root) {
       
        List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> currentlevelList = new ArrayList<>();
        if(root == null) {
            return levelOrder;
        }
       
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        while(!currentQueue.isEmpty()) {
           
           
            //Poll queue element for FIFO list population
            TreeNode tempNode = currentQueue.poll();
            currentlevelList.add(tempNode.val);
           
            if(tempNode.left_ptr != null) {
                nextQueue.add(tempNode.left_ptr);
            }
           
            if(tempNode.right_ptr != null) {
                nextQueue.add(tempNode.right_ptr);
            }
           
            if(currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                nextQueue = new LinkedList<TreeNode>();
                levelOrder.add(currentlevelList);
                currentlevelList = new ArrayList<Integer>();
            }
        }
       
        return levelOrder;
       
    }

}
