package com.java.practice.dsalgo.leetcode.design;
/**
 * 
 * @author saurabh
 *
 *
 * Design Add and Search Words Data Structure
Medium

3853

158

Add to List

Share
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.

Hint-Reference: 
https://www.youtube.com/watch?v=6O73KA53ayY
https://www.youtube.com/watch?v=T1M52UqQq3c
 */
public class DesignAddSearchWordDataStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class WordDictionary {

	    class TrieNode {
	        boolean isEnd;
	        TrieNode[] children;
	        
	        TrieNode() {
	            this.isEnd = false;
	            this.children = new TrieNode[26];
	        }
	    }
	    
	    TrieNode root = null;
	    public WordDictionary() {
	        root = new TrieNode();
	    }
	    
	    public void addWord(String word) {
	        if(word == null || word.length() == 0) {
	            return;
	        }
	        TrieNode node = root;
	        for(int i=0; i<word.length(); i++) {
	            char ch = word.charAt(i);
	            if(node.children[ch-'a'] == null) {
	                node.children[ch-'a'] = new TrieNode();
	            }
	            node = node.children[ch-'a'];
	        }
	        node.isEnd = true;
	    }
	    
	    public boolean search(String word) {
	        TrieNode node = root;
	        return search(word, 0, node);
	    }
	    
	    private boolean search(String word, int index, TrieNode node) {
	        if(node == null) {
	            return false;
	        }
	        if(index == word.length()) {
	            return node.isEnd;
	        }
	        char ch = word.charAt(index);
	        if(ch == '.') {
	            for(int i=0; i<26; i++) {
	                if(search(word, index + 1, node.children[i])) {
	                    return true;
	                }
	            }
	        }
	        else {
	            if(search(word, index + 1, node.children[ch-'a'])) {
	                return true;
	            }
	        }
	        return false;
	    }
	}

}
