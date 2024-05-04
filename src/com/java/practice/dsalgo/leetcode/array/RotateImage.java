package com.java.practice.dsalgo.leetcode.array;
/**
 * 
 * @author saurabh
 *
 *Rotate Image
Medium

8438

466

Add to List

Share
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

Hint-Reference:

Transpose of a matrix: https://www.youtube.com/watch?v=pqDZdKd1uLQ 
Rotate image: https://www.youtube.com/watch?v=uB0RgD4p3LY

T: O(n^2)
S: O(1)

 *
 */
public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void rotate(int[][] matrix) {
        // 1. find transpose
        transpose(matrix);
        // 2. reverse transpose matrix row 
        reverseRow(matrix);
    }
    
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    private void reverseRow(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            int left = 0;
            int right = n - 1;
            
            while(left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;
                right--;
            }
        }
    }

}
