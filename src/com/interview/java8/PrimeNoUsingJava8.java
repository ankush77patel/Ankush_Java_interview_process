package com.interview.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNoUsingJava8 {

	public static boolean isPrime(int number) {
		return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
	}

	public static boolean isPrimeNo(int num) {
		return !IntStream.rangeClosed(2, num / 2).anyMatch(i -> num % i == 0);
	}

	public static void main(String[] args) {
		List<Integer> collect = IntStream.range(1, 50).filter(e -> isPrime(e)).boxed().collect(Collectors.toList());
		List<String> asList = Arrays.asList("aa", "bb", "cc", "ee", "aa", "bb", "aa");
		List<String> collect2 = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(collect2);
		System.out.println(collect);
		List<Integer> collect3 = IntStream.range(1, 50).filter(i -> isPrimeNo(i)).boxed().collect(Collectors.toList());
		List<String> collect4 = asList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(collect3);
		System.out.println(collect4);

		Stream<String> of = Stream.of("I", "Love", "Stack Overflow");
		of.collect(Collectors.partitioningBy(s -> s.length() > 3)).entrySet()
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		List<Person> personData = getPersonData();
		List<Person> collect5 = personData.stream().collect(Collectors.groupingBy(p -> p.getAge() == 22)).entrySet()
				.stream().filter(e -> e.getKey()).flatMap(e -> e.getValue().stream()).collect(Collectors.toList());
		System.out.println(collect5);

		List<String> names = Arrays.asList("John", "Jane", "Michael", "Anna", "James");
		List<String> collect6 = names.stream().collect(Collectors.partitioningBy(e -> e.length() > 4)).entrySet()
				.stream().filter(e -> e.getKey()).flatMap(e -> e.getValue().stream()).collect(Collectors.toList());
		System.out.println(collect6);

	}

	public static List<Person> getPersonData() {
		Person p1 = new Person("Kosa", 21);
		Person p2 = new Person("Saosa", 21);
		Person p3 = new Person("Tiuosa", 22);
		Person p4 = new Person("Komani", 22);
		Person p5 = new Person("Kannin", 25);
		Person p6 = new Person("Kannin", 25);
		Person p7 = new Person("Tiuosa", 22);
		ArrayList<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		return list;
	}
}

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
