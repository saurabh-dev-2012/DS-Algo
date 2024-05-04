package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.Stack;

/**
 * 
 * @author saurabh
 *
 *
 * Decode String
Medium

8140

347

Add to List

Share
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

Hint-Reference:
https://www.youtube.com/watch?v=CW3ZYAN5Huo

T: O(n)
S: O(n)
 */
public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<String> ss = new Stack<>();
        int ptr = 0;
        String res = "";
        while(ptr < s.length()) {
            
            char ch = s.charAt(ptr);
            
            if(Character.isDigit(ch)) {
                int num = 0;
                while(Character.isDigit(s.charAt(ptr))) {
                    num = num * 10 + s.charAt(ptr) - '0';         
                    ptr++;
                }
                is.push(num);
            }
            else if(s.charAt(ptr) == '[') {
                ss.push(res);
                res = "";
                ptr++;
            }
            else if(s.charAt(ptr) == ']') {
                int count = is.pop();
                StringBuilder sb = new StringBuilder(ss.pop());
                for(int i=0; i<count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                ptr++;
            }
            else {
                res += ch;
                ptr++;
            }
        }
        
        return res;
    }

}
