package com.java.practice.dsalgo.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * 
 * @author saurabh
 *
 *895. Maximum Frequency Stack
Hard

2489

42

Add to List

Share
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 

Example 1:

Input
["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
Output
[null, null, null, null, null, null, null, 5, 7, 5, 4]

Explanation
FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 

Constraints:

0 <= val <= 109
At most 2 * 104 calls will be made to push and pop.
It is guaranteed that there will be at least one element in the stack before calling pop.

Hint-Reference:
https://www.youtube.com/watch?v=KVg4Y0sI4Iw
 *
 */
public class MaximumFrequencyStack {

    private Map<Integer, Stack<Integer>> stMap;
    private Map<Integer, Integer> fMap;
    private int maxFrequency;
    public MaximumFrequencyStack() {
        stMap = new HashMap<>();
        fMap = new HashMap<>();
        maxFrequency = Integer.MIN_VALUE;
    }
    
    public void push(int val) {
        int frequency = fMap.getOrDefault(val, 0);
        frequency++;
        fMap.put(val, frequency);
        
        if(!stMap.containsKey(frequency)) {
            stMap.put(frequency, new Stack<Integer>());
        }
        stMap.get(frequency).push(val);
        maxFrequency = Math.max(maxFrequency, frequency);
    }
    
    public int pop() {
        Stack<Integer> st = stMap.get(maxFrequency);
        int topValue = st.pop();
        if(st.isEmpty()) {
            stMap.remove(maxFrequency);
            maxFrequency--;
        }
        
        
        int oldFrequency = fMap.get(topValue);
        fMap.put(topValue, oldFrequency - 1);
        
        return topValue;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumFrequencyStack mfs = new MaximumFrequencyStack();
		mfs.push(5);
		mfs.push(7);
		mfs.push(5);
		mfs.push(7);
		mfs.push(4);
		mfs.push(5);
		
		int topValue1 = mfs.pop();
		int topValue2 = mfs.pop();
		int topValue3 = mfs.pop();
		int topValue4 = mfs.pop();
		
		System.out.println("Latest top value: " + topValue4);
		
	}
	
	

}
