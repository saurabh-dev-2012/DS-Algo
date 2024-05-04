package com.java.practice.dsalgo.ikandleetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal {
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private class Location implements Comparable<Location> {
        private int x;
        private int y;
        private int val;
        
        public Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Location l) {
            if(this.x != l.x) {
                return Integer.compare(this.x, l.x);
            }
            if(this.y <= l.y || this.y >= l.y) {
                return Integer.compare(l.y, this.y);
            }
            return Integer.compare(this.val, l.val);
        }
    }
    private List<Location> locations = null;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // Return list
        List<List<Integer>> verticalOrder = new ArrayList<>();
        
        if(root == null) {
            return verticalOrder;
        }
        locations = new ArrayList<>();
        // Method to populate x and y coordinates of location object corrosponding
        // to each node
        dfs(root, 0, 0);
        // sort locations as per x then y coordinate order and finally val 
        Collections.sort(locations);
        
        int x = locations.get(0).x;
        verticalOrder.add(new ArrayList<Integer>());
        
        // Iterate through locations list and populate verticalOrder list
        // such that all same x value locations fall in same list 
        for(Location l : locations) {
            if(x != l.x) {
                x = l.x;
                verticalOrder.add(new ArrayList<Integer>());
            }
            verticalOrder.get(verticalOrder.size() - 1).add(l.val);
        }
        
        return verticalOrder;
    }
    
    private void dfs(TreeNode root, int x, int y) {
        if(root != null) {
            locations.add(new Location(x, y, root.val));
            dfs(root.left, x - 1, y - 1);
            dfs(root.right, x + 1, y - 1);
        }
    }

}
