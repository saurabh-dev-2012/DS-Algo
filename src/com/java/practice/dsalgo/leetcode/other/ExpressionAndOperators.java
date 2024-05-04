package com.java.practice.dsalgo.leetcode.other;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author saurabh
 *
 *Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1

Hint-Reference: 

https://www.youtube.com/watch?v=jlZZyNEwPcU
 */
public class ExpressionAndOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    List<String> expressions = null;
    // boolean isNumAsTragetCheck = false;
    public List<String> addOperators(String num, int target) {
        expressions = new LinkedList<>();
        if(num == null || num.isEmpty()) {
            return expressions;
        }
        evaluateExpression(num, target, 0, 0, 0, 0, "", expressions);
        return expressions;
    }
    
    private void evaluateExpression(String num, int target, int index, long prevOperand, long currOperand, long val, String temp, List<String> expressions)    
    {
        if(index == num.length()) {
            if(val == target && currOperand == 0) {
                expressions.add(temp); 
            }
            return;
        }
        
        currOperand = currOperand * 10 + num.charAt(index) - '0';
        
        if(currOperand > 0) {
            evaluateExpression(num, target, index + 1, prevOperand, currOperand, val, temp, expressions);
            // if(index + 1 == num.length()) {
            //     isNumAsTragetCheck = true;
            // }
        }
        
        if(temp.isEmpty()) {
             evaluateExpression(num, target, index + 1, currOperand, 0, val+currOperand, temp + currOperand , expressions);
            return;
        }
        // +
         evaluateExpression(num, target, index + 1, currOperand, 0, val+currOperand, temp + "+" + currOperand, expressions);
        // -
         evaluateExpression(num, target, index + 1, 0 - currOperand, 0, val - currOperand, temp + "-" + currOperand, expressions);
        // *
         evaluateExpression(num, target, index + 1, prevOperand*currOperand, 0, val - prevOperand + prevOperand * currOperand, temp + "*" + currOperand, expressions);
        
    }

}
