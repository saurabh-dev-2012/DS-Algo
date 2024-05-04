package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *
 *269. Alien Dictionary
Hard

3238

668

Add to List

Share
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no Hint-Reference, return "". If there are multiple Hint-References, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

 

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.

Hint-Reference: 
https://www.youtube.com/watch?v=ef95J3BNbls

 */
public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> charOrder = new HashMap<>();
        int[] inDegree = new int[26];
        
        // Generate graph for character ordering
        buildGraph(words, charOrder, inDegree);
        
        // Return final string with bfs
        return bfs(charOrder, inDegree);
    }
    
    private void buildGraph(String[] words, Map<Character, Set<Character>> charOrder, int[] inDegree) {
        
        // populate map with empty order
        for(String word : words) {
            for(char c : word.toCharArray()) {
                charOrder.putIfAbsent(c, new HashSet<Character>());
            }
        }
        
        // compare character order and store difference in map
        for(int i=1; i<words.length; i++) {
            String first = words[i-1];
            String second = words[i];
            if(first.length() > second.length() && first.startsWith(second)){
                charOrder.clear();
                return;
            }
            for(int j=0; j<first.length(); j++) {
                char key = first.charAt(j);
                char value = second.charAt(j);
                if(key != value) {
                    if(!charOrder.get(key).contains(value)) {
                        inDegree[value - 'a']++;
                        charOrder.get(key).add(value);
                    }
                    break;
                }
            }
        }
    }
    
    private String bfs(Map<Character, Set<Character>> charOrder, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // Populate queue for indegree 0 chars
        for(char c : charOrder.keySet()) {
            if(inDegree[c - 'a'] == 0) {
                queue.offer(c);
                sb.append(c);
            }
        }
        
        while(!queue.isEmpty()) {
            char c = queue.poll();
            for(char nextC : charOrder.get(c)) {
                inDegree[nextC - 'a']--;
                if(inDegree[nextC - 'a'] == 0) {
                    queue.offer(nextC);
                    sb.append(nextC);
                }
            }
        }
        
        return charOrder.size() == sb.length() ? sb.toString() : "";
    }

}
