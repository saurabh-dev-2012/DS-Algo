package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.java.practice.dsalgo.ikandleetcode.tree.ConstructBSTFromPreOrder.TreeNode;
import com.java.practice.dsalgo.ikandleetcode.tree.PrintKSumPath.Node;
/**
 *
 * @author saurabh
 *
 * Input : k = 5  
        Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   6     2    
 *
 */
public class RightSideViewOfBinaryTree {

public static class TreeNode {
 int val;
 TreeNode left;
 TreeNode right;
 TreeNode() {}
 TreeNode(int val) { this.val = val; }
 TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
}
}
static ArrayList<Integer> rightside = new ArrayList<>();
public static void main(String[] args) {
// TODO Auto-generated method stub
TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(2);
        List<Integer> rightSideView = rightSideView(root);
        System.out.println();
       
}

// public static List<Integer> rightSideView(TreeNode root) {
//        if (root == null) return new ArrayList<Integer>();
//        
//        Queue<TreeNode> nextLevel = new LinkedList<>();
//        nextLevel.add(root);
//        Queue<TreeNode> currLevel = new LinkedList<>();        
//        ArrayList<Integer> rightside = new ArrayList<>();
//        
//        TreeNode node = null;
//        while (!nextLevel.isEmpty()) {
//            // prepare for the next level
//            currLevel =  new LinkedList<>(nextLevel);
//            nextLevel.clear();
//
//            while (! currLevel.isEmpty()) {
//                node = currLevel.poll();
//
//                // add child nodes of the current level
//                // in the queue for the next level
//                if (node.left != null)
//                    nextLevel.offer(node.left);    
//                if (node.right != null)
//                    nextLevel.offer(node.right);
//            }
//            
//            // The current level is finished.
//            // Its last element is the rightmost one.
//            if (currLevel.isEmpty())
//                rightside.add(node.val);    
//        }
//        return rightside;
//    }
/* Input : k = 5  
Root of below binary tree:
       1
     /    \
    3      -1
   /   \    / \
  2     1   4   5                        
 /     / \      \                    
1     1   6      2    
*
*/
static ArrayList<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> rightsideView = new ArrayList<>();
        if(root == null) {
            return rightsideView;
        }
       
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        while(!currentQueue.isEmpty()) {
           
           
            //Poll queue element for FIFO list population
            TreeNode tempNode = currentQueue.poll();
           
           
            if(tempNode.left != null) {
                nextQueue.add(tempNode.left);
            }
           
            if(tempNode.right != null) {
                nextQueue.add(tempNode.right);
            }
           
            if(currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                nextQueue = new LinkedList<TreeNode>();
                rightsideView.add(tempNode.val);
            }
        }
       
        return rightsideView;
       
}

// public static List<Integer> rightSideView(TreeNode root) {
//        if (root == null) return new ArrayList<Integer>();
//        
//        
//        dfs(root);
//        
//        return rightside;
//    }
//
// private static void dfs(TreeNode root) {
// if (root == null) return ;
//
// rightside.add(root.val);
//
// if(root.right != null) {
// dfs(root.right);
// }
// }
}
