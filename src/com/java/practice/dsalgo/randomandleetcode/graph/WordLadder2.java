package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *Word Ladder II
Hard

3526

331

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 1000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.

Hint-Reference:

//https://www.youtube.com/watch?v=vZNFOBEfib4&t=695s
//https://happygirlzt.com/code/126.html

 *
 */
public class WordLadder2 {
	
	
	List<List<String>> resultLadders;
	String beginWord, endWord;
	Set<String> wordSet = new HashSet<>();
	Map<String, Integer> graph = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
    	this.beginWord = beginWord;
    	this.endWord = endWord;
    	this.resultLadders = new ArrayList<>();
    	for(String word : wordList) {
    		wordSet.add(word);
    	}
//    	wordSet.add(beginWord);
//    	graph.put(beginWord, 0);
    	
    	buildGraph();
    	
    	if(graph.get(endWord) == null) {
    		return resultLadders;
    	}
    	
    	List<String> path = new ArrayList<>();
    	path.add(endWord);
    	
    	dfs(endWord, path);
    	
    	return resultLadders;
    }

	private void buildGraph() {
		// TODO Auto-generated method stub
		Queue<String> qu = new LinkedList<>();
		qu.add(beginWord);
		graph.put(beginWord, 0);
		while(qu.size() > 0) {
			String word = qu.poll();
			int n = word.length();
			char[] wordChars = word.toCharArray();
			for(int i=0; i<n; i++) {
				char c = wordChars[i];
				for(char j='a'; j<='z'; j++) {
					wordChars[i] = j;
					String newWord = String.valueOf(wordChars);
					if(wordSet.contains(newWord) && graph.get(newWord) == null) {
						graph.put(newWord, graph.get(word) + 1);
						qu.offer(newWord);
					}
				}
				wordChars[i] = c;
			}
		}
	}

	private void dfs(String word, List<String> path) {
		// TODO Auto-generated method stub
		if(word.equals(beginWord)) {
			List<String> list = new ArrayList(path);
			Collections.reverse(list);
			resultLadders.add(list);
			return;
		}
		int n = word.length();
		char[] wordChars = word.toCharArray();
		for(int i=0; i<n; i++) {
			char c = wordChars[i];
			for(char j='a'; j<='z'; j++) {
				wordChars[i] = j;
				String newWord = String.valueOf(wordChars);
				if(graph.get(newWord) != null && graph.get(newWord) + 1 == graph.get(word)) {
					path.add(newWord);
					dfs(newWord, path);
					path.remove(path.size()-1);
				}
			}
			wordChars[i] = c;
		}
	}
	
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
//    {
//        List<List<String>> res = new ArrayList<>();
//        Map<String, List<String>> graph = new HashMap<>();
//        Set<String> dict = new HashSet<>(wordList);
//         if(!dict.contains(endWord)) {
//            return res;
//        }
//        Set<String> startSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        startSet.add(beginWord);
//        endSet.add(endWord);
//        
//        // build graph
//        bfs(startSet, endSet, graph, dict, false);
//        
//        List<String> list = new ArrayList<>();
//        list.add(beginWord);
//        dfs(res, list, beginWord, endWord, graph);
        
//        return res;

//    }
    
//    private void bfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> graph, 
//                    Set<String> dict, boolean reverse) {
//        
//        if(startSet.size() == 0) {
//            return;
//        }
//        
//        if(startSet.size() > endSet.size()) {
//            bfs(endSet, startSet, graph, dict, !reverse);
//            return;
//        }
//        
//        Set<String> temp = new HashSet<>();
//        dict.removeAll(startSet);
//        boolean finish = false;
//        
//        for(String s : startSet) {
//            char[] chars = s.toCharArray();
//            for(int i=0; i<chars.length; i++) {
//                char old = chars[i];
//                
//                for(char c='a'; c<='z'; c++) {
//                    chars[i] = c;
//                    String word = new String(chars);
//                    
//                    if(dict.contains(word)) {
//                        
//                        if(endSet.contains(word)) {
//                            finish = true;
//                        }
//                        else {
//                            temp.add(word);
//                        }
//                        
//                        String key = reverse ? word : s;
//                        String val = reverse ? s : word;
//                        
//                        if(!graph.containsKey(key)) {
//                            graph.put(key, new ArrayList<>());
//                        }
//                        graph.get(key).add(val);
//                    }
//                }
//                chars[i] = old; 
//            }
//        }
//        
//        if(!finish) {
//            bfs(temp, endSet, graph, dict, reverse);
//        }
//        
//    }
    
//    private void dfs(List<List<String>> res, List<String> list, String beginWord, String endWord, 
//                    Map<String, List<String>> graph) {
//        if(beginWord.equals(endWord)) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        
//        if(!graph.containsKey(beginWord)) {
//            return;
//        }
//        
//        for(String word : graph.get(beginWord)) {
//            list.add(word);
//            dfs(res, list, word, endWord, graph);
//            list.remove(list.size() - 1);
//        }
//    }

}
