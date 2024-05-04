package com.java.practice.dsalgo.leetcode.array;
/**
 * 
 * @author saurabh
 *
 *
 *Shortest Word Distance
Easy

950

78

Add to List

Share
Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

 

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
 

Constraints:

1 <= wordsDict.length <= 3 * 104
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2


 */
public class ShortestDistanceBetweenWords243 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        
        for(int i=0; i<wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                index1 = i;
            }
            if(wordsDict[i].equals(word2)) {
                index2 = i;
            }
            
            if(index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        
        return min;
    }

}