package com.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberStartWith {
	public static void main(String[] args) {
		
		List<Integer> asList = Arrays.asList(2,222,234,55,69,82,32,24,72,28);
		List<Integer> collect = asList.stream()
		.map(e-> String.valueOf(e))
		.filter(e-> e.startsWith("2"))
		.map(Integer::valueOf)
		.collect(Collectors.toList());
		System.out.println(collect);
	}
}
