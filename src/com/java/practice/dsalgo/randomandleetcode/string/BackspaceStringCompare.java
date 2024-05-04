package com.java.practice.dsalgo.ikandleetcode.string;
/**
 * 
 * @author saurabh
 *
 *
 *Backspace String Compare
Easy

4788

208

Add to List

Share
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
 

Follow up: Can you solve it in O(n) time and O(1) space?

Hint-Reference:

https://www.youtube.com/watch?v=vgog1EuEJYQ

Time: O(n)
Space: O(1)


 */
public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1, tPointer = t.length() - 1;
        int s_Skips = 0, t_Skips = 0;
        
        while (sPointer >= 0 || tPointer >= 0) {
            
            while(sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    sPointer--;
                    s_Skips++;
                }
                else if (s_Skips > 0){
                    s_Skips--;
                    sPointer--;
                }
                else {
                    break;
                }
            }
            
            while(tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    tPointer--;
                    t_Skips++;
                }
                else if (t_Skips > 0) {
                    t_Skips--;
                    tPointer--;
                }
                else {
                    break;
                }
            }
            
            if(sPointer >= 0 && tPointer >=0 && s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }
    
            
            if((sPointer >= 0) != (tPointer >= 0)) {
                return false;
            }
            
            sPointer--;
            tPointer--;
            
        }
        
        return true;
    }

}
