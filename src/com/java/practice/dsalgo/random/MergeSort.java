package com.java.practice.dsalgo.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class MergeSort {

public static void main(String[] args) {
// TODO Auto-generated method stub
ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(5,8,3,9,4,1,7));
ListIterator<Integer> listIterator = merge_sort(arrayList).listIterator();
while(listIterator.hasNext()) {
System.out.print(listIterator.next() + ",");
}

}

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        // Write your code here.
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int center;
     
        if (arr.size() <= 1) {    
            return arr;
        } else {
            center = arr.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(arr.get(i));
            }
     
            //copy the right half of whole into the new arraylist.
            for (int i=center; i<arr.size(); i++) {
                    right.add(arr.get(i));
            }
     
            // Sort the left and right halves of the arraylist.
            left  = merge_sort(left);
            right = merge_sort(right);
     
            // Merge the results back together.
            merge(left, right, arr);
           
            return arr;
        }
       
    }
    
 // 5,8,3,9,4,1,7    
//  private static ArrayList <Integer> sort(ArrayList<Integer> arr, int start, int end) {
//      if (end == start ) {
//          return (ArrayList<Integer>)arr.subList(start, end);
//      }
//      else {
//           // devide input array list into 2 equal sub array lists and sort  
//          int mid = start + (end - start) / 2; // avoid integer overflow
//          ArrayList<Integer> leftList = sort(arr, start, mid);
//          ArrayList<Integer> rightList = sort(arr, mid + 1, end);
//          // merge the devided sub arrays after sorting such that the merged version is also sorted
//          merge(leftList, rightList, arr);
//      }
//      
//  }
 
  private static void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> whole) {
      int leftIndex = 0;
      int rightIndex = 0;
      int wholeIndex = 0;
   
      // As long as neither the left nor the right ArrayList has
      // been used up, keep taking the smaller of left.get(leftIndex)
      // or right.get(rightIndex) and adding it at both.get(bothIndex).
      while (leftIndex < left.size() && rightIndex < right.size()) {
          if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) <= 0) {
              whole.set(wholeIndex, left.get(leftIndex));
              leftIndex++;
          } else {
              whole.set(wholeIndex, right.get(rightIndex));
              rightIndex++;
          }
          wholeIndex++;
      }
   
      ArrayList<Integer> rest;
      int restIndex;
      if (leftIndex >= left.size()) {
          // The left ArrayList has been use up...
          rest = right;
          restIndex = rightIndex;
      } else {
          // The right ArrayList has been used up...
          rest = left;
          restIndex = leftIndex;
      }
   
      // Copy the rest of whichever ArrayList (left or right) was not used up.
      for (int i=restIndex; i<rest.size(); i++) {
          whole.set(wholeIndex, rest.get(i));
          wholeIndex++;
      }
  }

}
