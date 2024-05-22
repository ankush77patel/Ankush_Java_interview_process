package com.interview.practice;

import java.util.Arrays;
import java.util.List;

public class MaxInArrayList {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(60, 5, 45, 10, 6, 58, 70);
		Integer reduce = asList.stream().reduce(0, (a, b) -> a > b ? a : b);

		System.out.println(reduce);

		;
	}
}
