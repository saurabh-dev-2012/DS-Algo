package com.java.practice.dsalgo.leetcode.array;
/**
 * 
 * @author saurabh
 *
 *
 *Container With Most Water
Medium

14406

865

Add to List

Share
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
Accepted
1,302,892
Submissions
2,440,705
Seen this question in a real interview before?

Yes

No
The aim is to maximize the area formed between the vertical lines. The area of any container is calculated using the shorter line as length and the distance between the lines as the width of the rectangle.
Area = length of shorter vertical line * distance between lines
We can definitely get the maximum width container as the outermost lines have the maximum distance between them. However, this container might not be the maximum in size as one of the vertical lines of this container could be really short.

Hint-Reference: 
https://www.youtube.com/watch?v=4GIIy1o-3DM
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int maxArea(int[] height) {
	        int max = 0;
	        int i = 0, j = height.length - 1;
	        while(i < j) {
	            int area = (j-i) * Math.min(height[i], height[j]);
	            if(max < area) {
	                max = area;
	            }
	            if(height[i] < height[j]) {
	                i++;
	            }
	            else {
	                j--;
	            }
	        }
	        return max;
	    }

}
