package com.java.practice.dsalgo.ikandleetcode.string;
/**
 * 
 * @author saurabh
 *
 *The Number of Full Rounds You Have Played
Medium

152

208

Add to List

Share
You are participating in an online chess tournament. There is a chess round that starts every 15 minutes. The first round of the day starts at 00:00, and after every 15 minutes, a new round starts.

For example, the second round starts at 00:15, the fourth round starts at 00:45, and the seventh round starts at 01:30.
You are given two strings loginTime and logoutTime where:

loginTime is the time you will login to the game, and
logoutTime is the time you will logout from the game.
If logoutTime is earlier than loginTime, this means you have played from loginTime to midnight and from midnight to logoutTime.

Return the number of full chess rounds you have played in the tournament.

Note: All the given times follow the 24-hour clock. That means the first round of the day starts at 00:00 and the last round of the day starts at 23:45.

 

Example 1:

Input: loginTime = "09:31", logoutTime = "10:14"
Output: 1
Explanation: You played one full round from 09:45 to 10:00.
You did not play the full round from 09:30 to 09:45 because you logged in at 09:31 after it began.
You did not play the full round from 10:00 to 10:15 because you logged out at 10:14 before it ended.
Example 2:

Input: loginTime = "21:30", logoutTime = "03:00"
Output: 22
Explanation: You played 10 full rounds from 21:30 to 00:00 and 12 full rounds from 00:00 to 03:00.
10 + 12 = 22.
 

Constraints:

loginTime and logoutTime are in the format hh:mm.
00 <= hh <= 23
00 <= mm <= 59
loginTime and logoutTime are not equal.

Hint-Reference: 
https://www.youtube.com/watch?v=suD_h8XxzAE

 *
 */
public class TheNumberOfFullRoundsYouHavePlayed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfRounds("23:45", "8:00"));
	}
	
	    public static int numberOfRounds(String loginTime, String logoutTime) {
	        
	        int h1 = extractHours(loginTime);
	        int m1 = extractMinutes(loginTime);
	        
	        int h2 = extractHours(logoutTime);
	        int m2 = extractMinutes(logoutTime);
	        
	        if(h1 > h2) {
	            h2 = h2 + 24;
	        }
	        else if(h1 == h2 && m1 > m2) {
	            h2 = h2 + 24;
	        }
	        
	        int t1 = h1 * 60 + m1;
	        int t2 = h2 * 60 + m2;
	        int count = 0;
	        
	        if(t1 % 15 != 0) {
	            t1 = t1 + (15 - t1%15);
	        }
	        
	        for(int j=t1; j<=t2; j+=15) {
	            if(j+15 <= t2) {
	                count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private static int extractHours(String time) {
	        return Integer.valueOf(time.split(":")[0]);
	    }
	    
	    private static int extractMinutes(String time) {
	        return Integer.valueOf(time.split(":")[1]);
	    }

	}
