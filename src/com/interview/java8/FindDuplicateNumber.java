package com.interview.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicateNumber {
public static void main(String[] args) {
	List<Integer> asList = Arrays.asList(2,3,6,2,5,8,3,6,4,8,1,22);
	List<Integer> collect = asList.stream().filter(e-> Collections.frequency(asList,e)>1).collect(Collectors.toList());
	List<Integer> collect2 = asList.stream().filter(e->Collections.frequency(asList, e)>1).collect(Collectors.toList());
	
	System.out.println(collect2);
}
}
