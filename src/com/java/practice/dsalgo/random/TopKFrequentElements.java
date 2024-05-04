package com.java.practice.dsalgo.ik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements {

public static void main(String[] args) {
// TODO Auto-generated method stub

}

static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        // Write your code here.
        // Map to store number as key and their frequencies as value
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for(int number : arr){
        //Integer number = arr.get(i);
            if(frequencyMap.containsKey(number)){
int frequency = frequencyMap.get(number);
                frequencyMap.put(number, ++frequency);
            }
            else {
                frequencyMap.put(number, 1);
            }
        }
        //sort map with values in descending order
        List<Map.Entry<Integer, Integer>> listOfEntrySet = new LinkedList<Map.Entry<Integer, Integer>>
        (frequencyMap.entrySet());
       
        Collections.sort(listOfEntrySet, new Comparator<Map.Entry<Integer, Integer>>(){

@Override
public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
// TODO Auto-generated method stub
//sort in descending order
return o2.getValue().compareTo(o1.getValue());
}
       
        });
       
//        // result map to store sorted values
//        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
//        
//        for(Map.Entry<Integer, Integer> entry :  listOfEntrySet) {
//         resultMap.put(entry.getKey(), entry.getValue());
//        }
        // result list to store top k frequent numbers
        ArrayList<Integer> resultList = new ArrayList<Integer>();
       
        // iterate k times over result map to get k most frequent elements
        for(int i=0; i<k; i++) {
        resultList.add(listOfEntrySet.get(i).getKey());
        }
       
       
        return resultList;
    }


}
