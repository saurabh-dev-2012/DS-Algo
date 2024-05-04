package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RevereseOrderTraversalOfBinaryTree {

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

    public static List<List<Integer>> reverse_level_order_traversal(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
       
        if(root == null) {
            return levelOrder;
        }
        // each level list
        List<Integer> level = new ArrayList<>();
        //current queue to hold one level elements
        Queue<TreeNode> currentQueue = new LinkedList<>();
        //next queue to hold recursive level of elements
        Queue<TreeNode> nextQueue = new LinkedList<>();
        //stack to store reverse order  
       
        currentQueue.add(root);
        while(!currentQueue.isEmpty()) {
            //poll first element from queue
            TreeNode tempNode = currentQueue.poll();
            level.add(tempNode.val);
            if(tempNode.left_ptr != null) {
                nextQueue.add(tempNode.left_ptr);
            }
            if(tempNode.right_ptr != null) {
                nextQueue.add(tempNode.right_ptr);
            }
           
            if(currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                nextQueue = new LinkedList<TreeNode>();
                // if(levelOrder.size() > 0) {
                //     levelOrder.add(levelOrder.size() - 1, level);
                // }
                // else {
                    levelOrder.add(0,level);
                // }
                level = new ArrayList<Integer>();
            }
        }
       
        return levelOrder;
    }

}

