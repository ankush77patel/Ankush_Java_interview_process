package com.interview.practice;

import java.util.Arrays;

public class BinarySearchDemo {
	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 78, 6, 90, 87,25, 23, 45, 20, 10, 55, 63 };
		//[2, 4, 6, 6, 10, 20, 23, 25, 45, 55, 63, 78, 87, 90]
		Arrays.sort(a);
		System.out.println("Binary result :" + binarySearch(a, 9));

	}

	public static int binarySearch(int[] a, int key) {

		int l = 0;
		int h = a.length-1 ;
		int mid = 0;
		while (l <= h) {

			mid = (l + h) / 2;
			if (a[mid] == key)
				return a[mid];
			if (key<a[mid]) {
				h = mid - 1;
			} else
				l = mid + 1;
		}
		return 0;
	}
}
