package com.java.practice.dsalgo.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *Word Search II
Hard

5594

192

Add to List

Share
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.

Hint-Reference:
https://www.youtube.com/watch?v=B5wAm6pFYS8

Complexity

Time complexity: \mathcal{O}(M(4\cdot3^{L-1}))O(M(4⋅3 
L−1
 )), where MM is the number of cells in the board and LL is the maximum length of words.

It is tricky is calculate the exact number of steps that a backtracking algorithm would perform. We provide a upper bound of steps for the worst scenario for this problem. The algorithm loops over all the cells in the board, therefore we have MM as a factor in the complexity formula. It then boils down to the maximum number of steps we would need for each starting cell (i.e.4\cdot3^{L-1}4⋅3 
L−1
 ).

Assume the maximum length of word is LL, starting from a cell, initially we would have at most 4 directions to explore. Assume each direction is valid (i.e. worst case), during the following exploration, we have at most 3 neighbor cells (excluding the cell where we come from) to explore. As a result, we would traverse at most 4\cdot3^{L-1}4⋅3 
L−1
  cells during the backtracking exploration.

One might wonder what the worst case scenario looks like. Well, here is an example. Imagine, each of the cells in the board contains the letter a, and the word dictionary contains a single word ['aaaa']. Voila. This is one of the worst scenarios that the algorithm would encounter. pic

Note that, the above time complexity is estimated under the assumption that the Trie data structure would not change once built. If we apply the optimization trick to gradually remove the nodes in Trie, we could greatly improve the time complexity, since the cost of backtracking would reduced to zero once we match all the words in the dictionary, i.e. the Trie becomes empty.


Space Complexity: \mathcal{O}(N)O(N), where NN is the total number of letters in the dictionary.

The main space consumed by the algorithm is the Trie data structure we build. In the worst case where there is no overlapping of prefixes among the words, the Trie would have as many nodes as the letters of all words. And optionally, one might keep a copy of words in the Trie as well. As a result, we might need 2N2N space for the Trie.



 */
public class WordSearch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public class Trie {
        boolean isWord = false;
        Trie[] child = new Trie[26];
        public Trie() {
            
        }
    }
    Trie root = new Trie();
    boolean[][] flags = null;
    public List<String> findWords(char[][] board, String[] words) {
        if(words == null || words.length == 0 || board == null || board.length == 0) {
            return new ArrayList<>();
        }
        Set<String> foundWords = new HashSet<>();
        flags = new boolean[board.length][board[0].length];
        addToTrie(words);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(root.child[board[i][j] - 'a'] != null) {
                    searchWords(board, root, i, j, "", foundWords);
                }
            }
        }
        
        return new ArrayList(foundWords);
        
    }
    
    private void addToTrie(String[] words) {
        for(String word : words) {
            Trie node = root;
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i); 
                if(node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new Trie();
                }
                node = node.child[ch - 'a'];
            }
            node.isWord = true;
        }
    }
    
    private void searchWords(char[][] board, Trie node, int i, int j, String word, Set<String> foundWords) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
          flags[i][j] || node.child[board[i][j] - 'a'] == null) {
            return;
        }
        
        flags[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.isWord) {
            foundWords.add(word + board[i][j]);
        }
        
        searchWords(board, node, i+1, j, word + board[i][j], foundWords);
        searchWords(board, node, i-1, j, word + board[i][j], foundWords);
        searchWords(board, node, i, j+1, word + board[i][j], foundWords);
        searchWords(board, node, i, j-1, word + board[i][j], foundWords);
        
        flags[i][j] = false;
        
    }

}
