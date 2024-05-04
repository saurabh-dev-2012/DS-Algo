package com.java.practice.dsalgo.ik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements2ndApproachSameProgram {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        // Map to store number as key and their frequencies as value

        Map<Integer, Integer> mp
            = new HashMap<Integer, Integer>();
 
        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < arr.size(); i++) {
 
            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            mp.put(arr.get(i),
                   mp.getOrDefault(arr.get(i), 0) + 1);
        }
 
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list
            = new ArrayList<Map.Entry<Integer,
                                      Integer> >(
                mp.entrySet());
 
        // Sort the list
        Collections.sort(
            list,
            new Comparator<Map.Entry<Integer,
                                     Integer> >()
          {
                public int compare(
                    Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2)
                {
                    if (o1.getValue() == o2.getValue())
                        return o2.getKey() - o1.getKey();
                    else
                        return o2.getValue()
                            - o1.getValue();
                }
            });
       
        // result list to store first k frequent elements
        ArrayList<Integer> resultList = new ArrayList<Integer>();
 
        for (int i = 0; i < k; i++)
        resultList.add(list.get(i).getKey());
       
        return resultList;
    }


}
