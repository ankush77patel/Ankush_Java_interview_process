package com.interview.java8;

import java.util.Arrays;
import java.util.List;

public class SquareOfNumber {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1,10,20,30,4,5);
		 double asDouble = asList.stream().map(a->a*a).filter(e->e>100).mapToInt(e->e).average().getAsDouble();
		 System.out.println(asDouble);
	}
}
