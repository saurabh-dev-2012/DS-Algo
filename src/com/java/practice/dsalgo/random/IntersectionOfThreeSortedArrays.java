package com.java.practice.dsalgo.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfThreeSortedArrays {

public static void main(String[] args) {
// TODO Auto-generated method stub
       List<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(2,5,10));
       List<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(2,3,4,10));
       List<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(2,4,10));
       
       System.out.println(find_intersection(arr1,arr2,arr3));
}

    public static List<Integer> find_intersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
    // Write your code here
         
        return find_intersection_two_sorted(find_intersection_two_sorted(arr1, arr2), arr3);
    }
   
public static List<Integer> find_intersection_two_sorted(List<Integer> arr1, List<Integer> arr2) {
       
        int n = arr1.size();
        int k = arr2.size();
        int i = 0;
        int j = 0;
       
        List<Integer> intersection = new ArrayList<Integer>();
       
        while(i < n && j < k) {
            if (arr1.get(i) < arr2.get(j)){
                i++;
            }
            else if (arr1.get(i) > arr2.get(j)){
                j++;
            }
            else {
        //         if(intersection.size() == 0) {
      // intersection.add (arr1.get(i));
      // }
      //      else if(intersection.size() != 0 && intersection.get(intersection.size() - 1) != arr1.get(i)) {
            intersection.add (arr1.get(i));
          //  }
                i++;
                j++;
            }
        }
       
        return (intersection.size() == 0 ? new ArrayList<Integer>(Arrays.asList(-1)) : intersection);
    }

}
