package com.java.practice.dsalgo.ik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class OnlineMedian {

public static void main(String[] args) {
// TODO Auto-generated method stub

}


    // Complete the function below.
    public static List<Integer> online_median(List<Integer> stream) {
       
        int median = 0;
        PriorityQueue<Integer> minHeap = new  PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new  PriorityQueue<Integer>(Collections.reverseOrder());
        List<Integer> resultList = new ArrayList<Integer>();
//        Collections.binarySearch(null, null)
       
        for(Integer number : stream) {
           
           
            if(minHeap.size() == maxHeap.size()){
               
                if(number >= median) {
                    minHeap.add(number);
                    median = minHeap.peek();
                }
                else {
                    maxHeap.add(number);
                    median = maxHeap.peek();
                }
            }
            else {
               
                if(minHeap.size() > maxHeap.size()) {
                   
                    if(number > median) {
                        maxHeap.add(minHeap.remove());
                        minHeap.add(number);
                    }
                    else {
                        maxHeap.add(number);
                    }
                }
                else {
                    if(number > median) {
                       minHeap.add(number);
                    }
                    else {
                        minHeap.add(maxHeap.remove());
                        maxHeap.add(number);
                    }
                }
                median = (minHeap.peek() + maxHeap.peek()) / 2;
            }
           
            resultList.add(median);
           
        }
       
        return resultList;
       
    }

}

