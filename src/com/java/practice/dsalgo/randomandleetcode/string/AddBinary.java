package com.java.practice.dsalgo.ikandleetcode.string;
/**
 *
 * @author saurabh
 *
 *
 *
 *Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

 */
public class AddBinary {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += Character.getNumericValue(a.charAt(i--));
            }
            if(j >= 0) {
                sum += Character.getNumericValue(b.charAt(j--));
            }
            carry = sum > 1 ? 1 : 0;
            result.append(sum % 2);
        }
        if(carry != 0) {
            result.append(carry);
        }
       
        return result.reverse().toString();
    }

}

