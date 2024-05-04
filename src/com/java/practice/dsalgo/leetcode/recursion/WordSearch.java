package com.java.practice.dsalgo.leetcode.recursion;
/**
 * 
 * @author saurabh
 *
 *
 *Word Search
Medium

8587

325

Add to List

Share
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your Hint-Reference faster with a larger board?

Hint-Reference: 
https://www.youtube.com/watch?v=WO7uDd7ShW0

Time Complexity: \mathcal{O}(N \cdot 3 ^ L)O(N⋅3 
L
 ) where NN is the number of cells in the board and LL is the length of the word to be matched.

For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L3 
L
 .

We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.

As a result, overall the time complexity of the algorithm would be \mathcal{O}(N \cdot 3 ^ L)O(N⋅3 
L
 ).

Space Complexity: \mathcal{O}(L)O(L) where LL is the length of the word to be matched.

The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is \mathcal{O}(L)O(L).

 */
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int count, String word) {
        if(count == word.length()) {
            return true;
        }
    
        if(i == -1 || j == -1 || i == board.length || j == board[0].length || 
          board[i][j] != word.charAt(count)) {
            return false;
        }
    
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = dfs(board, i + 1, j, count + 1, word) ||
                        dfs(board, i - 1, j, count + 1, word) ||
                        dfs(board, i, j + 1, count + 1, word) ||
                        dfs(board, i, j - 1, count + 1, word);
    
        board[i][j] = temp;
    
        return found;
    }
        

}
