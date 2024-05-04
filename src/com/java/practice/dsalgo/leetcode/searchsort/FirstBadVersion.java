package com.java.practice.dsalgo.leetcode.searchsort;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int firstBadVersion(int n) {
        // if(n == 1) {
        //     return isBadVersion(n) ? 1 : 0;
        // }
        int first = 1;
        int last = n;
        while(first < last) {
            int mid = first + (last - first) / 2;
//            if(/isBadVersion(mid)) {
//                last = mid;
//            } else {
//                first = mid + 1;
//            }
        }
        return first;
    }

}
