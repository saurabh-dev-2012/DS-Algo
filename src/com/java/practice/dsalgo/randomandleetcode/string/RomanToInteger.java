package com.java.practice.dsalgo.ikandleetcode.string;

public class RomanToInteger {

public static void main(String[] args) {
// TODO Auto-generated method stub
System.out.println(romanToInt("IV"));
// for(int i=0; i<7; ++i) {
// System.out.println(i);
// }
}

public static int romanToInt(String s) {
	int result = 0;
	for (int i = 0; i < s.length(); i++) {
		int s1 = Value(s.charAt(i));

		if (i + 1 < s.length()) {
			int s2 = Value(s.charAt(i + 1));
			if (s1 >= s2) {
				result += s1;
			} else {
				result += s2 - s1;
				i++;
			}
		} else {
			result += s1;
		}
	}
	return result;
}

public static int Value(char ch) {
	switch (ch) {
	case 'I':
		return 1;
	case 'V':
		return 5;
	case 'X':
		return 10;
	case 'L':
		return 50;
	case 'C':
		return 100;
	case 'D':
		return 500;
	case 'M':
		return 1000;
	default:
		return -1;
	}
}

}
