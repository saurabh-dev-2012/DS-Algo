package com.java.practice.dsalgo.ikandleetcode.tree;
/**
 *
 * @author saurabh
 *Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6
 */

public class ConvertBinaryTreeToCircularDoublyLinkedList {

private static class TreeNode {
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode() {
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int val) {
            this.val = val;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }

public static void main(String[] args) {
// TODO Auto-generated method stub
TreeNode root = new TreeNode(1);
       root.left_ptr = new TreeNode(3);
       root.left_ptr.left_ptr = new TreeNode(2);
       root.left_ptr.right_ptr = new TreeNode(1);
       root.left_ptr.right_ptr.left_ptr = new TreeNode(1);
       root.right_ptr = new TreeNode(-1);
       root.right_ptr.left_ptr = new TreeNode(4);
       root.right_ptr.left_ptr.left_ptr = new TreeNode(1);
       root.right_ptr.left_ptr.right_ptr = new TreeNode(2);
       root.right_ptr.right_ptr = new TreeNode(5);
       root.right_ptr.right_ptr.right_ptr = new TreeNode(2);
       TreeNode cdll = binary_tree_to_cdll(root);
       System.out.println();
}

    static TreeNode binary_tree_to_cdll(TreeNode root){
       
        if(root == null) {
            return null;
        }
       
        TreeNode leftList = binary_tree_to_cdll(root.left_ptr);
        TreeNode rightList = binary_tree_to_cdll(root.right_ptr);
       
        //make a circular linked list of root TreeNode by pointing left & right of root TreeNode to itself
        root.left_ptr = root.right_ptr = root;
       
        return concatenate_two_cdll(concatenate_two_cdll(leftList, root), rightList);
       
    }
   
    private static TreeNode concatenate_two_cdll(TreeNode leftList, TreeNode rightList) {
       
        //if any of the list is null return other list
        if(leftList == null) {
            return rightList;
        }
        if(rightList == null) {
            return leftList;
        }
       
        // get the last TreeNode of left list and point
        // to the first TreeNode of right list
       
        TreeNode leftLast = leftList.left_ptr;
        TreeNode rightLast = rightList.left_ptr;
       
       
        leftLast.right_ptr = rightList;
        rightList.left_ptr = leftLast;
       
        // left of left list referes to the last TreeNode of right list
        leftList.left_ptr = rightLast;
       
        // right of last right list's pointer should point to first of left list
        rightLast.right_ptr = leftList;
       
        return leftList;
       
    }
   
    private TreeNode head = null;
    private TreeNode prev = null;
   
    public TreeNode treeToDoublyList(TreeNode root) {
        dfs(root);
        if(head == null) {
            return null;
        }
        head.left_ptr = prev;
        prev.right_ptr = head;
       
        return head;
    }
   
    private void dfs(TreeNode root) {
       
        if(root == null) {
            return;
        }
       
        // Travesrse left sub tree
        dfs(root.left_ptr);
       
        if(head == null) {
            head = root;
        }
        else {
            prev.right_ptr = root;
            root.left_ptr = prev;
        }
       
        // Assign current node to prev
        prev = root;
       
        // traverse right sub tree
        dfs(root.right_ptr);
       
    }

}
