package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *Most Common Word
Easy

1208

2464

Add to List

Share
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 

Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.

Hint-Reference:

https://www.youtube.com/watch?v=qbEtfHjAI8A
 */
public class MostCommonWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        Map<String, Integer> wordFreqMap = new HashMap<>();
        
        for(String bannedWord: banned) {
            bannedWords.add(bannedWord);
        }
        
        String[] words = paragraph.toLowerCase().split("\\W+");
        
        for(String word : words) {
            if(!bannedWords.contains(word)) {
                wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
            }
        }
        
        int max = 0;
        String mostCommonWord = "";
        for(String commonWord : wordFreqMap.keySet()) {
            int frequency = wordFreqMap.get(commonWord);
            if(frequency > max) {
                max = frequency;
                mostCommonWord = commonWord;
            }
        }
        
        return mostCommonWord;
    }

}
