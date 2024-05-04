package com.java.practice.dsalgo.ik;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CanAttendMeetings {

public static void main(String[] args) {
// TODO Auto-generated method stub

// 105 108
// 109 1000000000
// 90 105
// 111 112
}


    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
   
    if(intervals == null || intervals.size() == 0)
    return 1;
   
    // sort list of intervals by start time
        Collections.sort(intervals, new Comparator<List<Integer>>() {

public int compare(List<Integer> interval1, List<Integer> interval2) {
// TODO Auto-generated method stub
Integer interval1StartTime = interval1.get(0);
Integer interval2StartTime = interval2.get(0);
return interval1StartTime.compareTo(interval2StartTime);
}
});
        // if all meetings can be attended, canAttend = 1
        int canAttend = 1;
        // save previous interval
        List<Integer> previousInterval = intervals.get(0);
        for (int i=1; i<intervals.size(); i++) {
        List<Integer> currentInterval = intervals.get(i);
            int currentStartTime = currentInterval.get(0);
            //verify if there is any overlap
            if(currentStartTime < previousInterval.get(1)) {
                canAttend = 0;
            }
        }
        return canAttend;
    }

}