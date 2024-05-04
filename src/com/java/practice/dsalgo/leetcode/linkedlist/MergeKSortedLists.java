package com.java.practice.dsalgo.leetcode.linkedlist;
/**
 * 
 * @author saurabh
 *
 *
 *Merge k Sorted Lists
Hard

11212

447

Add to List

Share
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

Hint-Reference: 
https://www.youtube.com/watch?v=OaPaTaj0xYo
 */
public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 //Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        int interval = 1;
        int len = lists.length;
        while(interval < len) {
            for(int i=0; i<(len-interval); i+=(interval*2)) {
                mergeLists(lists, i, i+interval);
            }
            interval*=2;
        }
        return lists[0];
    }
    
    private void mergeLists(ListNode[] lists, int index1, int index2) {
        ListNode mergedNode = new ListNode(-1);
        ListNode ptr = mergedNode;
        
        ListNode l1 = lists[index1];
        ListNode l2 = lists[index2];
        
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                ptr.next = l2;
                break;
            }
            if(l2 == null) {
                ptr.next = l1;
                break;
            }
            
            if(l1.val <= l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            }
            else {
                ptr.next = l2;
                l2 = l2.next;
            }
            
            ptr = ptr.next;
        }
        
        lists[index1] = mergedNode.next;
    }

}
