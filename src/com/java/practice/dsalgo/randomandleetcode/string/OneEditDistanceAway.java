package com.java.practice.dsalgo.ikandleetcode.string;
/**
 *
 * @author saurabh
 *
 *Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.

A string s is said to be one distance apart from a string t if you can:

Insert exactly one character into s to get t.
Delete exactly one character from s to get t.
Replace exactly one character of s with a different character to get t.
 

Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "", t = ""
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "a", t = ""
Output: true
Example 4:

Input: s = "", t = "A"
Output: true
 

Constraints:

0 <= s.length <= 104
0 <= t.length <= 104
s and t consist of lower-case letters, upper-case letters and/or digits.
 */
public class OneEditDistanceAway {

public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println(isOneEditDistance("afc","abc"));
}

public static boolean isOneEditDistance(String s, String t) {
       int sLen = s.length();
       int tLen = t.length();
       
       if(sLen > tLen) {
        return isOneEditDistance(t, s);
       }
       
       if(tLen - sLen > 1) {
        return false;
       }
       
       for(int i=0; i<sLen; i++) {
        if(s.charAt(i) != t.charAt(i)) {
        if(sLen == tLen) {
        return s.substring(i+1).equals(t.substring(i+1));
        }
        else {
        return s.substring(i).equals(t.substring(i+1));
        }
        }
       }
       return (sLen + 1 == tLen);
}

}