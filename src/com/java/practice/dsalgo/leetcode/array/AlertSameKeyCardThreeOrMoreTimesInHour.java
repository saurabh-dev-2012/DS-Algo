package com.java.practice.dsalgo.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 *1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
Medium

187

283

Add to List

Share
LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.

You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.

Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".

Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.

Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.

 

Example 1:

Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
Output: ["daniel"]
Explanation: "daniel" used the keycard 3 times in a one-hour period ("10:00","10:40", "11:00").
Example 2:

Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
Output: ["bob"]
Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:20", "21:30").
 

Constraints:

1 <= keyName.length, keyTime.length <= 105
keyName.length == keyTime.length
keyTime[i] is in the format "HH:MM".
[keyName[i], keyTime[i]] is unique.
1 <= keyName[i].length <= 10
keyName[i] contains only lowercase English letters.

Hint-Reference:
https://www.youtube.com/watch?v=V3DEZqVYUtg

Time: O(nlogn)
Space: O(n)

 *
 */
public class AlertSameKeyCardThreeOrMoreTimesInHour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class Time {
        int hours;
        int minutes;
        
        public Time(String time) {
            
            String[] values = time.split(":"); 
            hours = Integer.valueOf(values[0]);
            minutes = Integer.valueOf(values[1]);
        }
        
        public boolean isWithinHour(Time other) {
            if(this.hours == other.hours) {
                return true;
            }
            return this.hours + 1 == other.hours && this.minutes >= other.minutes;
        }
    }
    
    
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        List<String> result = new ArrayList<>();
        
        if(keyName == null || keyName.length == 0 || keyTime == null ||
          keyTime.length == 0) {
            return result;
        }
        
        Map<String, List<Time>> times = new HashMap<>();
        
        
        for(int i=0; i<keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            
            times.putIfAbsent(name, new ArrayList<Time>());
            times.get(name).add(new Time(time));
            
        }
        
        for(String name : times.keySet()) {
            List<Time> timeValues = times.get(name);
            
            Collections.sort(timeValues, (a,b) -> {
               if(a.hours > b.hours) {
                   return 1;
               }
               else if (a.hours < b.hours) {
                   return -1;
               }
               else {
                   return a.minutes - b.minutes;
               }
            });
            
            if(isAlert(timeValues)) {
                result.add(name);
            }
        }
        
        Collections.sort(result);
        
        return result;
        
    }
    
    private boolean isAlert(List<Time> values) {
        for(int i=0; i<values.size() - 2; i++) {
            Time a = values.get(i);
            Time b = values.get(i + 2);
            if(a.isWithinHour(b)) {
                return true;
            }
        }
        return false;
    }

}
