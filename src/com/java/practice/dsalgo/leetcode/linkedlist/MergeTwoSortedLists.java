package com.java.practice.dsalgo.leetcode.linkedlist;

public class MergeTwoSortedLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		ListNode mergedList = mergeTwoLists(list1, list2);
		System.out.println();

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode mergeHead = new ListNode(-1);
		ListNode ptr = mergeHead;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				ptr.next = new ListNode(list1.val);
				list1 = list1.next;
				ptr = ptr.next;
			} else {
				ptr.next = new ListNode(list2.val);
				list2 = list2.next;
				ptr = ptr.next;
			}
		}
		while (list1 != null) {
			ptr.next = new ListNode(list1.val);
			list1 = list1.next;
			ptr = ptr.next;
		}
		while (list2 != null) {
			ptr.next = new ListNode(list2.val);
			list2 = list2.next;
			ptr = ptr.next;
		}
		return mergeHead.next;
	}

}
