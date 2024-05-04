package com.java.practice.dsalgo.leetcode.linkedlist;

import com.java.practice.dsalgo.leetcode.linkedlist.MergeKSortedLists.ListNode;

/**
 * 
 * @author saurabh
 *
 *Reverse Nodes in k-Group
Hard

6375

472

Add to List

Share
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?

Hint-Reference:
https://www.youtube.com/watch?v=FYsYAELWyRs
 *
 */
public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null) {
            return null;
        } 
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode temp = dummy;
        
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }
        
        temp = dummy;
        while(temp.next != null) {
            if(count<k) {
                break;
            }
            int nodes = k - 1;
            ListNode tempNext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            
            while(nodes -- > 0) {
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            
            count-=k;
            temp.next = first;
            tempNext.next = second;
            temp = tempNext;
        }
        return dummy.next;
    }

}
