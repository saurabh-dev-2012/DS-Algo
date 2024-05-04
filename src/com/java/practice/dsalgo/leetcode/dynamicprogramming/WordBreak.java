package com.java.practice.dsalgo.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author saurabh
 *
 *Word Break
Medium

9301

413

Add to List

Share
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

Hint-Reference:
https://www.youtube.com/watch?v=LPs6Qo5qlJM

 */
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private Map<String, Boolean> memoMap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //base 1
        if(s == null || s.length() == 0 || wordDict == null || 
          wordDict.size() == 0) {
            return false;
        }
        // base 2
        if(wordDict.contains(s)) {
            memoMap.put(s, true);
            return true;
        }
        // base 3
        if(memoMap.containsKey(s)) {
            return memoMap.get(s);
        }
        
        for(int i=0; i<s.length(); i++) {
            String part = s.substring(0, i+1);
            if(wordDict.contains(part) && wordBreak(s.substring(i+1), wordDict)) {
                memoMap.put(part, true);
                return true;
            }
        }
        memoMap.put(s, false);
        return false;
    }

}
