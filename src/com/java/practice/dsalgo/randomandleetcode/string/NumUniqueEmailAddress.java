package com.java.practice.dsalgo.ikandleetcode.string;

import java.util.HashSet;
import java.util.Set;

/** 
 * 
 * @author saurabh
 *
 */
public class NumUniqueEmailAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		System.out.println(numUniqueEmails(emails));
	}
	
	public static int numUniqueEmails(String[] emails) {
        Set<String> eSet = new HashSet<>();
        for(String email : emails) {
            String[] emailSplit = email.split("@");
            String localName = emailSplit[0];
            String domainName = emailSplit[1];
            
            // rule 1 for .
            localName = localName.replaceAll("\\.", "");
            
            //rule 2 for +
            localName = localName.split("\\+")[0];
            
            eSet.add(localName + "@" + domainName);
        }
        
        return eSet.size();
    }

}
