package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *Partition Labels
Medium

6485

254

Add to List

Share
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.

Hint-Reference:
https://www.youtube.com/watch?v=_I9di3CUOx4

 */
public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> partitions = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return partitions;
        }
        int prev = -1;
        int max = 0;
        
        // 1. Initialize partition map
        Map<Character, Integer> pMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            pMap.put(s.charAt(i), i);
        }
        
        //2. craete partition and store in result
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            max = Math.max(max, pMap.get(ch));
            if(max == i) {
                partitions.add(max - prev);
                prev = max;
            }
        }
        
        return partitions;
    }

}
