package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversalOfBinaryTree {

private static class TreeNode{
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(){
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int label){
            this.label = label;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }

public static void main(String[] args) {
// TODO Auto-generated method stub

}

	// 1 queue Hint-Reference

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> zigZagLevelOrder = new ArrayList<>();
		if (root == null) {
			return zigZagLevelOrder;
		}
		int levelValue = 1;
		Queue<TreeNode> levelQueue = new LinkedList<>();
		levelQueue.add(root);

		while (!levelQueue.isEmpty()) {

			List<Integer> level = new ArrayList<>();
			int n = levelQueue.size();
			for (int i = 0; i < n; i++) {

				TreeNode node = levelQueue.remove();
				if (levelValue % 2 == 0) {
					level.add(0, node.label);
				} else {
					level.add(node.label);
				}
				if (node.left_ptr != null) {
					levelQueue.add(node.left_ptr);
				}
				if (node.right_ptr != null) {
					levelQueue.add(node.right_ptr);
				}
			}

			zigZagLevelOrder.add(level);
			levelValue++;
		}

		return zigZagLevelOrder;
	}

    public static List<List<Integer>> zigzag_level_order_traversal(TreeNode root) {
        List<List<Integer>> zigzalLevelOrder = new ArrayList<>();
        if(root == null) {
            return zigzalLevelOrder;
        }
       
        List<Integer> zigzagLevel = new ArrayList<>();
        int level = 1;
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        while(!currentQueue.isEmpty()) {
            // poll the first node from the level order queue
            TreeNode tempNode = currentQueue.poll();
            if(level % 2 == 0) {
                zigzagLevel.add(0,tempNode.label);
            }
            else {
                zigzagLevel.add(tempNode.label);
            }
           
            if(tempNode.left_ptr != null) {
                nextQueue.add(tempNode.left_ptr);
            }
            if(tempNode.right_ptr != null) {
                nextQueue.add(tempNode.right_ptr);
            }
            if(currentQueue.isEmpty()) {
                level++;
                currentQueue = nextQueue;
                nextQueue = new LinkedList<TreeNode>();
                zigzalLevelOrder.add(zigzagLevel);
                zigzagLevel = new ArrayList<Integer>();
            }
        }
        return zigzalLevelOrder;
    }

}
