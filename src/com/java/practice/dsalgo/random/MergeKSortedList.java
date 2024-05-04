package com.java.practice.dsalgo.ik;

import java.util.Arrays;
import java.util.List;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

public class MergeKSortedList {

public static void main(String[] args) {
// TODO Auto-generated method stub
//node1
SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
node1.next = new SinglyLinkedListNode(3);
node1.next.next = new SinglyLinkedListNode(5);

//node2
SinglyLinkedListNode node2 = new SinglyLinkedListNode(3);
node2.next = new SinglyLinkedListNode(4);

//node3
SinglyLinkedListNode node3 = new SinglyLinkedListNode(7);

//node4
SinglyLinkedListNode node4 = new SinglyLinkedListNode(3);
node4.next = new SinglyLinkedListNode(9);

SinglyLinkedListNode sortedLinkedList = merge_k_lists(Arrays.asList(node1,node2,node3,node4));
}


public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {

int last = lists.size() - 1;
while(last != 0) {
int i = 0;
int j = last;
while(i<j) {
lists.set(i, mergeTwoSortedLists(lists.get(i), lists.get(j)));
i++;
j--;

if(i>=j) {
last = j;
}
}
}

return lists.get(0);
}

private static SinglyLinkedListNode mergeTwoSortedLists(SinglyLinkedListNode a, SinglyLinkedListNode b) {


// SinglyLinkedListNode result = null;
// SinglyLinkedListNode root = result;
//
// while(a != null && b!= null) {
//      int data1 = a.data;
//      int data2 = b.data;
//      if(data1 <= data2) {
//      result = a;
//      if(root == null) {
//      root = result;
//      }
//          result = result.next;
//          a = a.next;
//      }
//      else {
//      result = b;
//      if(root == null) {
//      root = result;
//      }
//          result = result.next;
//          b = b.next;
//      }
// }
// //copy rest of the elements from node a
// while (a != null){
// result = a;
//        result = result.next;
//        a = a.next;
// }
//
// //copy rest of the elements from node b
// while (b != null){
// result = b;
//        result = result.next;
//        b = b.next;
// }
//  
// return root;

SinglyLinkedListNode result = null;
    /* Base cases */
    if (a == null)
        return b;
    else if (b == null)
        return a;

    /* Pick either a or b, and recur */
    if (a.data <= b.data) {
        result = a;
        result.next = mergeTwoSortedLists(a.next, b);
    }
    else {
        result = b;
        result.next = mergeTwoSortedLists(a, b.next);
    }

    return result;
}



//int n = lists.size();
//int i = 0;
//SinglyLinkedListNode result = null;
//SinglyLinkedListNode root = null;
//while(i<n) {
//  SinglyLinkedListNode node = lists.get(i++);
//  if(result == null) {
//      result = node;
//      root = result;
//  }
//  else {
//      while(node != null && result!= null) {
//          int data1 = node.data;
//          int data2 = result.data;
//          if(data1 <= data2) {
//              SinglyLinkedListNode temp = result;
//              result.data = node.data;
//              result.next = temp;
//              result = result.next;
//              node = node.next;
//          }
//          else {
//              SinglyLinkedListNode newNode = new SinglyLinkedListNode(node.data);
//              SinglyLinkedListNode temp = result.next;
//              result.next= newNode;
//              newNode.next = temp;
//              result = result.next.next;
//              node = node.next;
//          }
//      }
//      //copy rest of the elements from node
//      while (node != null){
//          result = new SinglyLinkedListNode(node.data);
//          result = result.next;
//          node = node.next;
//      }
//      
//    
//  }
//}
//return root;


}
