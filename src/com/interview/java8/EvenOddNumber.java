package com.interview.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenOddNumber {
	public static void main(String[] args) {

		
		List<Integer> asList = Arrays.asList(10,2,3,6,5,8,7,9);
		List<Integer> collect = asList.stream().filter(e->(e%2==0)).collect(Collectors.toList());
		System.out.println(collect);
		
		List<Integer> odd = asList.stream().filter(e->(e%2!=0)).collect(Collectors.toList());
		System.out.println(odd);
		
	}
}
