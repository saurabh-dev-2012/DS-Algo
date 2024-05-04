package com.java.practice.dsalgo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author saurabh
 *
 *Group Anagrams
Medium


Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

T: O(n * klogk) - k is maximum length of characters in a string
S: O(nk)

 */
public class GroupAnagrams {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> stringsMap = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!stringsMap.containsKey(key)) {
                stringsMap.put(key, new ArrayList());
            }
            stringsMap.get(key).add(str);
        }
        return new ArrayList(stringsMap.values());
    }

}