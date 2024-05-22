package com.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AvgOfNumbers {
public static void main(String[] args) {
	List<Integer> asList = Arrays.asList(1,2,5);
	OptionalDouble average = asList.stream().mapToInt(e->e).average();
	System.out.println(average.getAsDouble());
}
}
