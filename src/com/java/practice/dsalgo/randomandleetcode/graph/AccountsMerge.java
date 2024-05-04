package com.java.practice.dsalgo.ikandleetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author saurabh
 *
 *Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j] <= 30
accounts[i][0] consists of English letters.
accounts[i][j] (for j > 0) is a valid email.

Hint-Reference: 

https://www.youtube.com/watch?v=FtANGhNJuNs
 */

public class AccountsMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Set<String>> emailGraphMap = new HashMap<>();
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        // 1. Generate a graph
        for(List<String> account: accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            // Add email name map for email and name
            emailNameMap.put(firstEmail, name);
            if(!emailGraphMap.containsKey(firstEmail)) {
                emailGraphMap.put(firstEmail, new HashSet<String>());
            }
            for(int i = 2; i<account.size(); i++) {
                String email = account.get(i);
                emailNameMap.put(email, name);
                if(!emailGraphMap.containsKey(email)) {
                    emailGraphMap.put(email, new HashSet<String>());
                }
                emailGraphMap.get(email).add(firstEmail);
                emailGraphMap.get(firstEmail).add(email);
            }
        }
        
        
        // 2. Find a connected component using dfs and generate a merged list
        Set<String> seenEmail = new HashSet<String>();
        for(String email : emailNameMap.keySet()) {
            String name = emailNameMap.get(email);
            if(seenEmail.contains(email)) {
                continue;
            }
            List<String> mergedAccount = new ArrayList<>();
            findConnectedComponenets(email, emailGraphMap, seenEmail, mergedAccount);
            // sort accounts email address wise 
            Collections.sort(mergedAccount);
            mergedAccount.add(0, name);
            mergedAccounts.add(mergedAccount);
        }
        
        return mergedAccounts;
    }
    
    private void findConnectedComponenets(String email, Map<String, Set<String>> emailGraphMap, Set<String> seenEmail, List<String> mergedAccount) {
        if(seenEmail.contains(email)) {
            return;
        }
        seenEmail.add(email);
        mergedAccount.add(email);
        for(String connectedEmail : emailGraphMap.get(email)) {
            findConnectedComponenets(connectedEmail, emailGraphMap, seenEmail, mergedAccount);
        }
    }

}
