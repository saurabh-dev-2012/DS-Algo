package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.List;


public class MergeTwoBSTs {

private static class TreeNode {
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


    static TreeNode merge_two_BSTs(TreeNode root1, TreeNode root2){
            List<Integer> list1 = new ArrayList<>();
            storeInOrder(root1, list1);
            List<Integer> list2 = new ArrayList<>();
            storeInOrder(root2, list2);
            List<Integer> resultList = mergeTwoSortedArrayLists(list1, list2);
            return constructBSTFromInorderList(resultList, 0, resultList.size() - 1);
    }
   
    /* Method to store inorder tarversal for tree
    */
    private static void storeInOrder(TreeNode root, List<Integer> inOrderList) {
        if(root == null) {
            return;
        }
        storeInOrder(root.left_ptr, inOrderList);
        inOrderList.add(root.val);
        storeInOrder(root.right_ptr, inOrderList);
    }
   
    private static List<Integer> mergeTwoSortedArrayLists(List<Integer> list1, List<Integer> list2) {
        int i=0, j=0;
        List<Integer> resultList = new ArrayList<Integer>();
        while(i < list1.size() && j < list2.size()) {
           
            if(list1.get(i) <= list2.get(j)) {
                resultList.add(list1.get(i));
                i++;
            }
            else {
                resultList.add(list2.get(j));
                j++;
            }
           
        }
        // Add remaining elements from list1
        while(i < list1.size()) {
            resultList.add(list1.get(i));
                i++;
        }
        // Add remaining elements from list2
        while(j < list2.size()) {
            resultList.add(list2.get(j));
                j++;
        }
       
        return resultList;
    }
   
    private static TreeNode constructBSTFromInorderList(List<Integer> inOrderList, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inOrderList.get(mid));
        root.left_ptr = constructBSTFromInorderList(inOrderList, start, mid - 1);
        root.right_ptr = constructBSTFromInorderList(inOrderList, mid + 1, end);
        return root;
    }

}
