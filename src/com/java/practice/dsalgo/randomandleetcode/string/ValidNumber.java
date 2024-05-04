package com.java.practice.dsalgo.ikandleetcode.string;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean isNumber(String s) {
        
        int countPlusMinus = 0;
        boolean digitSeen = false, eSeen = false, dotSeen = false; 
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // digit
            if(Character.isDigit(ch)) {
                digitSeen = true;
            }
            // +/-
            else if(ch == '+' || ch == '-') {
                
                if(countPlusMinus == 2) {
                    return false;
                }
                
                if(i>0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') {
                    return false;
                }
                if(i == s.length() - 1) {
                    return false;
                }
                countPlusMinus++;
            }
            // ., e., .7e.
            else if(ch == '.') {
                if(dotSeen || eSeen) {
                    return false;
                }
                if(i == s.length() - 1 && !digitSeen) {
                    return false;
                }
                dotSeen = true;
            }
            // e/E
            // eE, e45, E
            else if(ch == 'e' || ch == 'E') {
                if(eSeen || !digitSeen || i == s.length() - 1) {
                    return false;
                }
                eSeen = true;
            }
            else {
                return false;
            }
        }
        
        return true;
    }

}
