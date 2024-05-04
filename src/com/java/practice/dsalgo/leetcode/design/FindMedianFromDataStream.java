package com.java.practice.dsalgo.leetcode.design;

import java.util.PriorityQueue;

/**
 * 
 * @author saurabh
 *
 *295. Find Median from Data Stream
Hard

6350

120

Add to List

Share
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your Hint-Reference?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your Hint-Reference?

Hint-Reference:
https://www.youtube.com/watch?v=TzkPMVoIgWM

 *
 */
public class FindMedianFromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int maxSize;
    int minSize;
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minSize = 0;
        maxSize = 0;
    }
    
    public void addNum(int num) {
        if(minSize == 0) {
            minHeap.offer(num);
            minSize++;
            return;
        }
        
        if(maxSize == 0) {
            if(num < minHeap.peek()) {
                maxHeap.offer(num);
            }
            else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            maxSize++;
            return;
        }
        
        if(num < minHeap.peek()) {
            maxHeap.offer(num);
            maxSize++;
        }
        else {
            minHeap.offer(num);
            minSize++;
        }
        
        balance();
    }
    
    private void balance() {
        if(Math.abs(maxSize - minSize) <= 1) {
            return;
        }
        if(maxSize > minSize) {
            minHeap.offer(maxHeap.poll());
            minSize++;
            maxSize--;
        }
        else {
            maxHeap.offer(minHeap.poll());
            maxSize++;
            minSize--;
        }
    }
    
    public double findMedian() {
        if(maxSize > minSize) {
            return maxHeap.peek();
        }
        if(minSize > maxSize) {
            return minHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

}
