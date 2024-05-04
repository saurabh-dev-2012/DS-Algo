package com.java.practice.dsalgo.ikandleetcode.tree;

public class ConvertSortedListToBinarySearchTree {

static class SinglyLinkedListNode {
        public Integer data;
        public SinglyLinkedListNode next;

        SinglyLinkedListNode(Integer node_data) {
            this.data = node_data;
            this.next = null;
        }
    }

static class TreeNode {
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(int val) {
            this.val = val;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    };

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    static SinglyLinkedListNode listHead;
    static TreeNode sorted_list_to_bst(SinglyLinkedListNode head) {
        listHead = head;
        int size = findSize(head);
        return constructBST(0, size-1);
    }
   
    static int findSize(SinglyLinkedListNode head) {
        int size = 0;
        SinglyLinkedListNode ptr = head;
        while(ptr != null) {
            ptr = ptr.next;
            size++;
        }
        return size;
    }
   
    static TreeNode constructBST(int l, int r) {
        if(l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = constructBST(l, mid-1);
       
        //construct root after left tree tarversal
        TreeNode root = new TreeNode(listHead.data);
        //point left tree node to root
        root.left_ptr = left;
       
        // move list node to next value
        listHead = listHead.next;
       
        root.right_ptr = constructBST(mid+1, r);
       
        return root;
    }

}

