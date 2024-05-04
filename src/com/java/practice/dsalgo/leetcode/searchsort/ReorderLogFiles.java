package com.java.practice.dsalgo.leetcode.searchsort;

import java.util.Arrays;

/**
 * 
 * @author saurabh
 *
 *Reorder Data in Log Files
Easy

1607

3772

Add to List

Share
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Constraints:

1 <= logs.length <= 100
3 <= logs[i].length <= 100
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier.

Hint-Reference:
https://www.youtube.com/watch?v=nLa5bxT4ixQ

Complexity Analysis

Let NN be the number of logs in the list and MM be the maximum length of a single log.

Time Complexity: \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN)

First of all, the time complexity of the Arrays.sort() is \mathcal{O}(N \cdot \log N)O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked \mathcal{O}(N \cdot \log N)O(N⋅logN) times.

For each invocation of the compare() function, it could take up to \mathcal{O}(M)O(M) time, since we compare the contents of the logs.

Therefore, the overall time complexity of the algorithm is \mathcal{O}(M \cdot N \cdot \log N)O(M⋅N⋅logN).

Space Complexity: \mathcal{O}(M \cdot \log N)O(M⋅logN)

For each invocation of the compare() function, we would need up to \mathcal{O}(M)O(M) space to hold the parsed logs.

In addition, since the implementation of Arrays.sort() is based on quicksort algorithm whose space complexity is \mathcal{O}(\log n)O(logn), assuming that the space for each element is \mathcal{O}(1)O(1)). Since each log could be of \mathcal{O}(M)O(M) space, we would need \mathcal{O}(M \cdot \log N)O(M⋅logN) space to hold the intermediate values for sorting.

In total, the overall space complexity of the algorithm is \mathcal{O}(M + M \cdot \log N) = \mathcal{O}(M \cdot \log N)O(M+M⋅logN)=O(M⋅logN).


 *
 */
public class ReorderLogFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            
            boolean isDigitLog1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigitLog2 = Character.isDigit(split2[1].charAt(0));
            
            if(!isDigitLog1 && !isDigitLog2) {
                int compare = split1[1].compareTo(split2[1]);
                if(compare == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                else {
                    return compare;
                }
            }
            
            if(isDigitLog1 && isDigitLog2) {
                return 0;
            }
            
            if(isDigitLog1 && !isDigitLog2) {
                return 1;
            }
            else {
                return -1;
            }
        });
        
        return logs;
    }

}
