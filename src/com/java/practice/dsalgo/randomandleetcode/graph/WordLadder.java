package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

/**
 * 
 * @author saurabh
 *
 *Word Ladder
Hard

7486

1616

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.

Hint-Reference:
https://www.youtube.com/watch?v=O3hUyXyHeBw

 *
 */
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    
    class WordDict {
        String word;
        int len;
        WordDict(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null ||
          endWord.length() == 0 || beginWord.length() != endWord.length()) {
            return 0;
        }
        
        Queue<WordDict> queue = new LinkedList<>();
        queue.add(new WordDict(beginWord, 1));
        while(!queue.isEmpty()) {
            WordDict obj = queue.poll();
            ListIterator<String> it = wordList.listIterator();
            while(it.hasNext()) {
                String word = it.next();
                if(isAdjecant(obj.word, word)) {
                    it.remove();
                    queue.add(new WordDict(word, obj.len + 1));
                    if(word.equals(endWord)) {
                        return obj.len + 1;
                    }
                }
            }
        }
        return 0;
    }
    
    private boolean isAdjecant(String word1, String word2) {
        if(word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        int len = word1.length();
        for(int i=0; i<len; i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        return count <= 1 ? true : false;
    }

}
