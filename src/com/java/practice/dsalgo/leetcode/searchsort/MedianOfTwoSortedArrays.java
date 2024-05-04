package com.java.practice.dsalgo.leetcode.searchsort;
/**
 * 
 * @author saurabh
 *
 *Median of Two Sorted Arrays
Hard

15160

1900

Add to List

Share
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

Hint-Reference:
https://www.youtube.com/watch?v=5qDN3ZDtyWg

 *
 */
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {};
		int[] nums2 = {1};
		System.out.println(findMedianSortedArraysOp2(nums1,nums2));
	}
	
    
    public static double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        
        if(nums1.length < nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int low = 0;
        int high = nums1.length;
        int total = nums1.length + nums2.length;
        
        while(low <= high) {
            int aLeft = (low + high) / 2;
            int bLeft = (total + 1) / 2 - aLeft;
            
            int aLM1 = (aLeft == 0) ? Integer.MIN_VALUE : nums1[aLeft-1];
            int aL = (aLeft == nums1.length) ? Integer.MAX_VALUE : nums1[aLeft];
            int bLM1 = (bLeft == 0) ? Integer.MIN_VALUE : nums2[bLeft-1];
            int bL = (bLeft == nums2.length) ? Integer.MAX_VALUE : nums2[bLeft];
            
            // check whether the partition is valid
            if (aLM1 <= bL && bLM1 <= aL) {
                double median = 0.0;
                
                if(total % 2 == 0) {
                    int lMax = Math.max(aLM1, bLM1);
                    int rMin = Math.min(aL, bL);
                    
                    median = (lMax + rMin) / 2.0;
                }
                else {
                    median = (double)Math.max(aLM1, bLM1);
                }
                return median;
            }
            else if (aLM1 > bL) {
                // select more elements from left half from 'nums2' array
                high = aLeft - 1;
            }
            else if (bLM1 > aL) {
                // select more elements from left half from 'num1' array
                low = aLeft + 1;
            }
        }
        
        return 0;
    }
    
    public static double findMedianSortedArraysOp2(int[] nums1, int[] nums2) {
        
    	if(nums2.length<nums1.length){
            int []temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
       
       int m=nums1.length;
       int n=nums2.length;
       
       int total=m+n;
       int lo=0;
       int hi=m;
       
       
       while(lo<=hi){
           int a=(hi+lo)/2;
           int b=(total+1)/2-a;
           
           int a1=(a==0)?Integer.MIN_VALUE:nums1[a-1];
           int a2=(a==m)?Integer.MAX_VALUE:nums1[a];
           int b1=(b==0)?Integer.MIN_VALUE:nums2[b-1];
           int b2=(b==n)?Integer.MAX_VALUE:nums2[b];
        
           if(a1<=b2 && b1<=a2){
               double res=0.0;
               
               if(total%2==0){
                   int maxV=Math.max(a1,b1);
                   int minV=Math.min(a2,b2);
                   
                   res=((double)maxV+minV)/2.0;
               }else{
                   res=(double)Math.max(a1,b1);
               }
               
               return res;
           }
           
           if(a1>b2){
               hi=a-1;
           }else if(b1>a2){
               lo=a+1;
           }
           
           
       }
       
       return 0.0;
   }
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m+n];
        int i=0, j=0, k=0;
        
        while(i < m && j< n) {
            if(nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
            }
            else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while(i < m) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j < n) {
            merged[k] = nums2[j];
            j++;
            k++;
        }
        
        if((m+n)%2 != 0) {
            return merged[(m+n)/2];
        }
        else{
            int p = (m+n)/2;
            double m1 = merged[p];
            double m2 = merged[p-1];
            return (m1+m2)/2;
        }
    }

}
