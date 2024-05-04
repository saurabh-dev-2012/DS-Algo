package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

public class LevelOrderTraversalOfNaryBinaryTree {

static class TreeNode
    {
        int label;
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode(int _label)
        {
            label = _label;
            children.clear();
        }
    };

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    public static List<List<Integer>> level_order(TreeNode root)
    {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) {
            return levelOrder;
        }
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        while(!currentQueue.isEmpty()) {
           
            //poll from queue the first node added
            TreeNode tempNode = currentQueue.poll();
            level.add(tempNode.label);
            if(tempNode.children != null || tempNode.children.size() > 0) {
                int n = tempNode.children.size();
                for(int i=0; i<n; i++) {
                    nextQueue.add(tempNode.children.get(i));
                }
            }
            if(currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                nextQueue = new LinkedList<TreeNode>();
                levelOrder.add(level);
                level = new ArrayList<Integer>();
            }
           
        }
       
        return levelOrder;
       
    }

}
