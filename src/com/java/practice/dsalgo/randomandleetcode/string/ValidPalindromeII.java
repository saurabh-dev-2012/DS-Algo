package com.java.practice.dsalgo.ikandleetcode.string;
/**
 *
 * @author saurabh
 *
 *Valid Palindrome II
Easy

3670

225

Add to List

Share
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

Hint-Reference:
https://www.youtube.com/watch?v=wTaJp8_bSLQ
 */
public class ValidPalindromeII {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length() - 1;
        int count1 = 0;
        int count2 = 0;
       
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                i++;
                count1++;
            }
           
        }
        // Reset vars
        i = 0;
        j = s.length() - 1;
       
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else {
                j--;
                count2++;
            }
           
        }
       
        if(count1 == 0 || count2 == 0) {
            return true;
        }
       
        if(count1 == 1 || count2 == 1) {
            return true;
        }
       
        return false;
    }

}