package com.javatechie;

public class LogestPlindromSubString {

	public static void main(String[] args) {

		String str = "aba";
		System.out.println("Longest palindrom " + findLongestPalindrom(str));

	}

	public static String findLongestPalindrom(String str) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			int len1 = expandAroundCenter(str, i, i);
			int len2 = expandAroundCenter(str, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len-1)/2;
				end = i + (len / 2);
			}
		}

		return str.substring(start, end + 1);
	}

	public static int expandAroundCenter(String str, int left, int right) {
		while(left>=0 && right<str.length() && str.charAt(right)==str.charAt(left)) {
			left--;
			right++;
		}
		return right-left-1;
	}
}
