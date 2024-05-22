package com.interview.practice;

import java.util.Arrays;
import java.util.List;

public class ShiftZeroRightInArray {
	public static void main(String[] args) {
		Integer[] a= {1,2,3,0,4,0,5,0,6,0,0,7,0,8};
		System.out.println(a.length);
		shiftZerosRight(a);
		List<Integer> asList = Arrays.asList(a);
		
		System.out.println(asList);
	}

	private static void shiftZerosRight(Integer[] a) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			//shift non zero element first
			if(a[i]!=0)
				a[count++]=a[i];
		}
		while(count<a.length) {
			a[count++]=0;
		}
	}
}
