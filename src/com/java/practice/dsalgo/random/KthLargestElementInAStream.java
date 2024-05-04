package com.java.practice.dsalgo.ik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    public static List<Integer> kth_largest(int k, List<Integer> initial_stream,
            List<Integer> append_stream) {
// Write your code here
    List<Integer> resultArrayList = new ArrayList<Integer>();
    KthLargest kthLargest = new KthLargest(k, initial_stream);
    for(Integer appendNumber : append_stream) {
    resultArrayList.add(kthLargest.add(appendNumber));
    }
    return resultArrayList;

    }
   
     

}

class KthLargest {
private int k;
private PriorityQueue<Integer> priorityQueue;

public KthLargest(int k, List<Integer> stream) {
this.k = k;
this.priorityQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

@Override
public int compare(Integer o1, Integer o2) {
// TODO Auto-generated method stub
	return o1.compareTo(o2);
}
});
//initialize queue with list
for(int element : stream) {
this.priorityQueue.add(element);
if(this.priorityQueue.size() > k)
this.priorityQueue.remove();
}


}

public Integer add (int element) {

this.priorityQueue.add(element);
if(this.priorityQueue.size() > this.k)
this.priorityQueue.remove();
return this.priorityQueue.peek();
}
}