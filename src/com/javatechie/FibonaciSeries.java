package com.javatechie;

public class FibonaciSeries {
	public static void main(String[] args) {
		int a=-1,b=1,c=0;
		int n=12;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			c=a+b;
			a=b;
			b=c;
			
			sb.append(c).append(" ");
		}
		System.out.println(sb.toString());
	}
}
