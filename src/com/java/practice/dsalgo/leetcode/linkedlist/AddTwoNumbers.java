package com.java.practice.dsalgo.leetcode.linkedlist;



/**
 *
 * @author saurabh
 *
 *You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Hint-Reference:

https://www.youtube.com/watch?v=6njc0UO73Jk

 */
public class AddTwoNumbers {

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

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        int v1=0, v2=0, carry=0, sum=0;
       
        ListNode sumHead = new ListNode(-1);
        ListNode ptr = sumHead;
       
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            else {
                v1 = 0;
            }
           
            if(l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            else {
                v2 = 0;
            }
            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
           
            ListNode temp = new ListNode(sum);
            ptr.next = temp;
            ptr = ptr.next;
        }
        if(carry != 0) {
            ListNode carryNode = new ListNode(carry);
            ptr.next = carryNode;
        }
        return sumHead.next;
    }

}