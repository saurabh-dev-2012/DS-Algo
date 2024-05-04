package com.java.practice.dsalgo.leetcode.linkedlist;

import com.java.practice.dsalgo.leetcode.linkedlist.MergeTwoSortedLists.ListNode;

/**
 *
 * @author saurabh
 *
 *Reorder List
Medium

4932

190

Add to List

Share
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
Accepted
416,812
Submissions
910,754
Seen this question in a real interview before?

Yes

No


Hint-Reference:
1. https://www.youtube.com/watch?v=xRYPjDMSUFw
2. https://www.youtube.com/watch?v=meOY1wajrnw
3. https://www.youtube.com/watch?v=rEYm4yLHSHQ

 */
public class ReorderList {

public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public static void main(String[] args) {
// TODO Auto-generated method stub

}

public void reorderList(ListNode head) {
       
        if(head == null || head.next == null) {
            return;
        }
        // 1. Divide the list in two halves using two pointers
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
       
        prev.next = null;
       
        // 2. Reverse second list
        ListNode l2 = reverse(slow);
       
        // 3. Merge two lists by joining alternate nodes
        merge(l1, l2);
    }
   
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
   
    private void merge(ListNode l1, ListNode l2) {
       while(l1 != null) {
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;
       
            l1.next = l2;
            if(l1_next == null) {
                break;
            }
           
           l2.next = l1_next;
           
           l1 = l1_next;
           l2 = l2_next;
        }
    }
}