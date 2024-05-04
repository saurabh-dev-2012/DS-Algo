package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *Given an array of unique strings words, return all the word squares you can build from words. The same word from words can be used multiple times. You can return the answer in any order.

A sequence of strings forms a valid word square if the kth row and column read the same string, where 0 <= k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 

Example 1:

Input: words = ["area","lead","wall","lady","ball"]
Output: [["ball","area","lead","lady"],["wall","area","lead","lady"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input: words = ["abat","baba","atan","atal"]
Output: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 4
All words[i] have the same length.
words[i] consists of only lowercase English letters.
All words[i] are unique.

Hint-Reference:

https://www.youtube.com/watch?v=YTQjsPiMtRk

T: O(n)
S: O(n)
 *
 */
public class WordSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<String, List<String>> prefixMap = new HashMap<>();
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if(words == null || words.length == 0) {
            return result;
        }
        buildPrefixMap(prefixMap, words);
        for(String word : words) {
            LinkedList<String> list = new LinkedList<>();
            list.add(word);
            backTrack(1, list, result, word.length());
        }
        return result;
    }
    
    private void backTrack(int step, LinkedList<String> list, List<List<String>> result, int n) {
        if(list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String word : list) {
            sb.append(word.charAt(step));
        }
        String prefix = sb.toString();
        List<String> wordList = prefixMap.getOrDefault(prefix, new ArrayList<String>());
        
        for(String word : wordList) {
            list.add(word);
            backTrack(step + 1, list, result, word.length());
            list.removeLast();
        }
        
    }
    
    private void buildPrefixMap(Map<String, List<String>> prefixMap, String[] words) {
        for(String word : words) {
            for(int i=0; i<word.length(); i++) {
                String prefix = word.substring(0, i);
                prefixMap.putIfAbsent(prefix, new ArrayList<>());
                prefixMap.get(prefix).add(word);
            }
        }
    }

}
