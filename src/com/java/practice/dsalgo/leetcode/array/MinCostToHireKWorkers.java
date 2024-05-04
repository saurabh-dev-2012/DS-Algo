package com.java.practice.dsalgo.leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 
 * @author saurabh
 *
 *Minimum Cost to Hire K Workers
Hard

1618

196

Add to List

Share
There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation: We pay 70 to 0th worker and 35 to 2nd worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation: We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.
 

Constraints:

n == quality.length == wage.length
1 <= k <= n <= 104
1 <= quality[i], wage[i] <= 104

Hint-Reference:
https://www.youtube.com/watch?v=7-vZbPEuvwM

T: O(nlogn)

S: O(n)

 *
 */
public class MinCostToHireKWorkers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n]; 
        for(int i=0; i<n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        Arrays.sort(workers);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        
        double cost = Double.MAX_VALUE;
        int totalQuality = 0;
        
        for(Worker worker: workers) {
            totalQuality += worker.getQuality();
            maxHeap.offer(worker.getQuality());
            
            if(maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            if(maxHeap.size() == k) {
                cost = Math.min(cost, worker.getRatio() * totalQuality);
            }
        }
        
        return cost;
    }
    
    public class Worker implements Comparable<Worker> {
        private int quality;
        private int wage;
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }
        
        public int getQuality() {
            return this.quality;
        }
        
        public double getRatio() {
            return (double) wage / quality;
        }
        
        public int compareTo(Worker otherWorker) {
            if(this.getRatio() > otherWorker.getRatio()) {
                return 1;
            }
            else if (this.getRatio() < otherWorker.getRatio()) {
                return -1;
            }
            return 0;
        }
    }

}
