package com.java.practice.dsalgo.ikandleetcode.string;

public class ValidateIPAddress {

public static void main(String[] args) {
// TODO Auto-generated method stub
String ipAddress = ":::::::";
System.out.println(validIPAddress(ipAddress));
}

public static String validIPAddress(String queryIP) {
        if(queryIP == null || queryIP.length() == 0) {
            return "Neither";
        }
        if(queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4Address(queryIP);
        }
        if(queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6Address(queryIP);
        }
        return "Neither";
    }
   
    private static String validateIPv4Address(String ip) {
        String[] values = ip.split("\\.");
        for(String value : values) {
            if(value.length() == 0 || value.charAt(0) == '0' || value.length() > 3) {
                return "Neither";
            }
            for(char ch : value.toCharArray()) {
                if(!Character.isDigit(ch)) {
                    return "Neither";
                }
            }
            if(Integer.parseInt(value) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
   
    private static String validateIPv6Address(String ip) {
        String[] values = ip.split(":", -5);
        String ipV6Chars = "0123456789abcdefABCDEF";
        for(String value : values) {
            if(value.length() == 0 || value.length() > 4) {
                return "Neither";
            }
            for(char ch : value.toCharArray()) {
                if(ipV6Chars.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

}
