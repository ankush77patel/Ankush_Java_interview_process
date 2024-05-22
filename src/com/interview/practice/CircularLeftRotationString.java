package com.interview.practice;

public class CircularLeftRotationString {

	public static void main(String[] args) {
		String s1 = "DBDB";
		String s2 = "BDBD";

		if(isStringRotate(s1, s2))
		System.out.println("String s1 is rotation of s2.");
		else
			System.out.println("String s1 is not rotation of s2.");
	}

	public static boolean isStringRotate(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		else {
			int bi=s1.lastIndexOf(s2.charAt(0));
			for(int i=0;i<s2.length();i++) {
				if(s1.charAt(bi++)!=s2.charAt(i))
					return false;
				 if(bi==s1.length() && i+1<s2.length())
					 bi=0;
			}
		}
		
		return true;
	}
}
