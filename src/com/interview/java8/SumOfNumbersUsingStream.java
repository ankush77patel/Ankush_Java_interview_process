package com.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumOfNumbersUsingStream {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(10, 20, 3, 6, 5, 55, 85, 1, 4, 5, 6);
		Optional<Integer> reduce = asList.stream().reduce((a, b) -> a + b);
		System.out.println(reduce.get());
		Optional<Integer> reduce2 = asList.stream().reduce((a, b) -> {
			if (a > b)
				return a;
			else
				return b;

		});

		System.out.println(reduce2.get());

	}
}
