package com.java.practice.dsalgo.leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashMap;

import java.util.Map;

// You tube Hint-Reference explanation: 
// https://www.youtube.com/watch?v=Xc4sICC8m4M&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=78&t=0s
// https://www.youtube.com/watch?v=xDEuM5qa0zg
public class LRUCacheImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    class Node {
        Node next, prev;
        int key, value;
        public Node (int k, int v) {
            key = k;
            value = v;
        }
    }
    
    private Node head = new Node(0, 0), tail = new Node(0, 0);
    private Map<Integer, Node> lruMap = new HashMap<>();
    private int capacity;
    
    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            // remove for least recently used 
            remove(node);
            // add right after head node
            insert(node);
            
            return node.value;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(lruMap.containsKey(key)) {
            Node node = lruMap.get(key);
            remove(node);
        }
        
        if(lruMap.size() == this.capacity) {
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }
    
    private void insert(Node node) {
        lruMap.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    
    private void remove(Node node) {
        lruMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
	
	class LRUCache extends LinkedHashMap<Integer, Integer>{

	    private int capacity;
	    
	    public LRUCache(int capacity) {
	        super(capacity, 0.75F, true);
	        this.capacity = capacity;
	    }
	    
	    public int get(int key) {
	        return super.getOrDefault(key, -1);
	    }
	    
	    public void put(int key, int value) {
	        super.put(key, value);
	    }
	    
	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
	        return size() > this.capacity;
	    }
	}

}
