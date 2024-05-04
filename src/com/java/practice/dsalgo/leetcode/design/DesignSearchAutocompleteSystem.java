package com.java.practice.dsalgo.leetcode.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *642. Design Search Autocomplete System
Hard

1691

116

Add to List

Share
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Implement the AutocompleteSystem class:

AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
List<String> input(char c) This indicates that the user typed the character c.
Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If there are fewer than 3 matches, return them all.
 

Example 1:

Input
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
Output
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]

Explanation
AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
obj.input("a"); // return []. There are no sentences that have prefix "i a".
obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
 

Constraints:

n == sentences.length
n == times.length
1 <= n <= 100
1 <= sentences[i].length <= 100
1 <= times[i] <= 50
c is a lowercase English letter, a hash '#', or space ' '.
Each tested sentence will be a sequence of characters c that end with the character '#'.
Each tested sentence will have a length in the range [1, 200].
The words in each input sentence are separated by single spaces.
At most 5000 calls will be made to input.

Hint-Reference: 
https://www.youtube.com/watch?v=Zm3-cGKKFLg
https://happygirlzt.com/code/642.html

 *
 */
public class DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class TrieNode implements Comparable<TrieNode> {
        String s;
        TrieNode[] children;
        int times;
        List<TrieNode> hotList;
        
        public TrieNode() {
            this.s = null;
            this.children = new TrieNode[128];
            this.times = 0;
            this.hotList = new ArrayList<>();
        }
        
        public int compareTo(TrieNode node) {
            if(this.times == node.times) {
                return this.s.compareTo(node.s);
            }
            return node.times - this.times;
        }
        
        public void update(TrieNode node) {
            if(!this.hotList.contains(node)) {
                this.hotList.add(node);
            }
            
            Collections.sort(this.hotList);
            
            if(this.hotList.size() > 3) {
                this.hotList.remove(this.hotList.size() - 1);
            }
        }
    }
    
    TrieNode root;
    TrieNode curr;
    StringBuilder sb;
    
    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curr = root;
        sb = new StringBuilder();
        
        for(int i=0; i<times.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    public void add(String sentence, int t) {
        TrieNode node = root;
        List<TrieNode> visited = new ArrayList<>();
        for(char ch : sentence.toCharArray()) {
             if(node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }
            node = node.children[ch];
            visited.add(node);
        }
        
        node.s = sentence;
        node.times += t;
        
        for(TrieNode tmp : visited) {
            tmp.update(node);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c == '#') {
            add(sb.toString(), 1);
            curr = root;
            sb = new StringBuilder();
            return res;
        }
        sb.append(c);
        
        if(curr != null) {
            curr = curr.children[c];
        }
        
        if(curr == null) {
            return res;
        }
        
        for(TrieNode node : curr.hotList) {
            res.add(node.s);
        }
        
        return res;
    }

}
