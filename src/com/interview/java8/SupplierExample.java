package com.interview.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupplierExample {

	public static void main(String[] args) {
		Supplier<String> nameSupplier = () -> generateRandomName();
		Supplier<Integer> ageSupplier = () -> generateRandomAge();
		Supplier<List<Integer>> numRange = () -> getNumbersList(30);
		System.out.println(numRange.get());

		List<Person> personList = generatePersonList(nameSupplier, ageSupplier, 10);
		System.out.println(personList);
		System.out.println(personList.size());
	}

	public static String generateRandomName() {
		String[] names = { "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace" };
		int randomIndex = new Random().nextInt(names.length);
		return names[randomIndex];
	}

	public static int generateRandomAge() {
		return new Random().nextInt(50) + 18;
	}

	public static List<Person> generatePersonList(Supplier<String> nameSupplier, Supplier<Integer> ageSupplier,
			int size) {
		List<Person> personList = new ArrayList<>();

		for (int i = 1; i <= size; i++) {
			personList.add(new Person(nameSupplier.get(), ageSupplier.get()));
		}

		return personList;
	}

	public static List<Integer> getNumbersList(int num) {

		return IntStream.rangeClosed(1, num).boxed().collect(Collectors.toList());
	}
}
