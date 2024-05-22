package com.javatechie;

public class ShiftZerosRightSide {
	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 3, 6, 5, 0, 5 ,7,8,0,0};
		System.out.println(a.length);
		shiftNonZeroElementsToRight(a);
		System.out.println(a.length);
		for (int i : a) {
			System.out.print(i+" ");
		}
		System.out.println("Shift elements in left direction");
		System.out.println(a.length);
		shiftNonZeroElementsToLeft(a);
		System.out.println(a.length);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
	
	public static void shiftNonZeroElementsToRight(int[] nums) {
		int index = nums.length - 1;

		for (int i = index; i >= 0; i--) {
			if (nums[i] != 0) {
				nums[index--] = nums[i];
			}

		}

		while (index >= 0)
			nums[index--] = 0;
	}
	
	public static void shiftNonZeroElementsToLeft(int[] nums) {
		int index=0;
		for (int i = 0; i<nums.length; i++) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
			}

		}

		while (index <nums.length)
			nums[index++] = 0;
	}
	
}
