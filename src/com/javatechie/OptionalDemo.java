package com.javatechie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OptionalDemo {

	public static Customer getCustomerByEmailId(String email) throws Exception {
		List<Customer> customers = EkartDataBase.getAll();
		return customers.stream().filter(customer -> customer.getEmail().equals(email)).findAny()
				.orElseThrow(() -> new Exception("no customer present with this email id"));

	}

	public static void main(String[] args) throws Exception {

		Customer customer = new Customer(101, "john", "test@gmail.com", Arrays.asList("397937955", "21654725"), 500000d,
				"INDIA");

		List<Customer> listCustomer = EkartDataBase.getAll();
		// List<Optional<String>> collect =
		// listCustomer.stream().map(e->e.getEmail()).collect(Collectors.toList());
		// System.out.println(collect);

		List<String> phoneNumbers = listCustomer.stream().flatMap(e -> e.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		// System.out.println(phoneNumbers);

		// print customer details based on country
		Map<String, List<Customer>> collect = listCustomer.stream()
				.collect(Collectors.groupingBy(Customer::getCountry, Collectors.toList()));
		// collect.forEach((k,v)->System.out.println("Key "+k+" Value"+v));
		// print count of customer belong to country
		Map<String, Long> collect2 = listCustomer.stream()
				.collect(Collectors.groupingBy(Customer::getCountry, Collectors.counting()));
		// collect2.forEach((k,v)->System.out.println("Key "+k+" Value"+v));
		// print max/min Customer salary in give collection
		Optional<Double> max = listCustomer.stream().map(e -> e.getSalary()).max((o1, o2) -> o1.compareTo(o2));
		System.out.println(max.get());
		// print max/min Customer salary in give collection
		Optional<Double> min = listCustomer.stream().map(e -> e.getSalary()).max((o1, o2) -> -o1.compareTo(o2));
		System.out.println(min.get());

		// Print salary of customer based on country wise
		listCustomer.stream()
				.collect(Collectors.groupingBy(Customer::getCountry,
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Customer::getSalary)))))
				.forEach((k, v) -> System.out.println(k + "  " + v));

		// getCustomerByEmailId("pqr");

	}
}
