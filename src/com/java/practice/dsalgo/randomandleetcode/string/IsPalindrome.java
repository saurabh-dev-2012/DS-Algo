package com.java.practice.dsalgo.ikandleetcode.string;
/**
 *
 * @author saurabh
 *
 *
 *A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class IsPalindrome {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }  
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
           
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
           
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
           
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
       
        return true;
    }

}