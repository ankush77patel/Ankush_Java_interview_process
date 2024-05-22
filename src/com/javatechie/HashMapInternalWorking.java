package com.javatechie;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternalWorking {
	public static void main(String[] args) {

		Map<String, Integer> hs = new HashMap<>();
		hs.put(null, 100);
		hs.put("aa", 100);
		hs.put("bb", 22);
		hs.put("cc", 55);
		hs.put("dd", 65);
		hs.put("ee", 99);
		hs.put(null, 200);
		System.out.println(hs);
		int[] b = { 95, 10, 3, 4, 6, 90, 20, 40, 100, 98,105,102,106,500 };
		System.out.println("Max :" + getMaxNumberInArray(b));
		System.out.println("Sec :" + getSecondMaxNumberInArray(b));
	}

	public static int getMaxNumberInArray(int[] a) {
		int no = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > no)
				no = a[i];
		}
		return no;
	}

	public static int getSecondMaxNumberInArray(int[] a) {
		int max = a[0];
		int sec = max;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				sec = max;
				max = a[i];
			} else if (sec < a[i]) {
				sec = a[i];
			}
		}
		return sec;
	}
}
