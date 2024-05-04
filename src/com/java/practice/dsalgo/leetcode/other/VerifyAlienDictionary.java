package com.java.practice.dsalgo.leetcode.other;
/**
 * 
 * @author saurabh
 *
 *Verifying an Alien Dictionary
Easy

2487

868

Add to List

Share
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.

Hint-Reference: 
https://www.youtube.com/watch?v=jK5a8T9q4pc

 */
public class VerifyAlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] mappings = new int[26];
        int seq = 0;
        for(char ch : order.toCharArray()) {
            mappings[ch - 'a'] = seq++;
        } 
        
        for(int i=0 ; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            int word1Len = word1.length();
            int word2Len = word2.length();
            int len = Math.min(word1Len, word2Len);
            
            if(word1.startsWith(word2) && len != word1Len && len == word2Len) {
                return false;
            }
            for(int l=0; l<len; l++) {
                if(mappings[word1.charAt(l) - 'a'] > mappings[word2.charAt(l) - 'a']) {
                    return false;
                }
                if(mappings[word1.charAt(l) - 'a'] < mappings[word2.charAt(l) - 'a']) {
                    break;
                }
            }
            
        }
        return true;
    }

}
