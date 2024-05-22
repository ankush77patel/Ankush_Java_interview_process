package com.javatechie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateElementByJava8 {
	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1, 2, 3, 1, 5, 6, 4, 5, 3);
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");

		Set<Integer> hs = new HashSet<>();
		// Find duplicate no's by using hash set approach.
		Set<Integer> duplicateByHashSet = asList.stream().filter(e -> !hs.add(e)).collect(Collectors.toSet());
		System.out.print("duplicateByHashSet " + duplicateByHashSet);
		System.out.println();

		// Find duplicate no's by using group by function
		List<Integer> duplicateByGroupby = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println("duplicateByGroupby " + duplicateByGroupby);

		// Find duplicate string words using group by function
		List<String> duplicateWordsByGroupBy = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("duplicateWordsByGroupBy " + duplicateWordsByGroupBy);
		System.out.println();

		String s = "aabbccddefgkklmno";
		List<String> wordsList = Arrays.asList(s.split(""));
		System.out.println("Find duplicate charators in a string :");
		List<String> duplicateCharactors = wordsList.stream()
				.filter(e -> (s.length() - s.replaceAll(e, "").length()) > 1).distinct().collect(Collectors.toList());
		System.out.println("duplicateCharactors " + duplicateCharactors);
		System.out.println();
		System.out.println("Find non duplicate charators in a string :");
		List<String> uniqueCharactors = wordsList.stream().filter(e -> (s.length() - s.replaceAll(e, "").length()) == 1)
				.collect(Collectors.toList());
		System.out.println("uniqueCharactors " + uniqueCharactors);

		Optional<String> of = Optional.of("Hello");
		System.out.println(of);
		Optional<Object> ofNullable = Optional.ofNullable(null);
		System.out.println(ofNullable);
		Optional<Object> empty = Optional.empty();
		System.out.println(empty);

		System.out.println("Reverse string");

		List collect = Stream.of(s).map(e -> new StringBuilder(e).reverse()).collect(Collectors.toList());
		System.out.println(collect);
		String reversedStringStream = Optional.ofNullable(s)
                .map(e -> new StringBuilder(e).reverse().toString()).orElse("");
                
		System.out.println(reversedStringStream);
		
		int a=88;
		int b=889;
		System.out.println(a==b);
		
		System.out.println("Common elements in to arrays or list");
		List<Integer> of2 = Arrays.asList(1,2,3,4,5,6,5,8,9,5);
		List<Integer> of3 =Arrays.asList(2,5,6,9,8,1,7,5,410,20,20,20,2,36,55,44);
		
		List<Integer> collect2 = of2.stream().filter(of3::contains).collect(Collectors.toList());
		System.out.println(collect2);
		
		

	}
}
