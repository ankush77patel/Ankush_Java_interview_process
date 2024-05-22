package com.javatechie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee123 {
	private String empName;
	private int age;
	private double salary;

	public Employee123(String empName, int age, double salary) {
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}

	public String getEmpName() {
		return empName;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "empName='" + empName + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}
}

public class PracticeJava8 {

	public static void main(String[] args) {
		List<Employee123> employees = new ArrayList<>();
		employees.add(new Employee123("John", 30, 50000));
		employees.add(new Employee123("Alice", 26, 60000));
		employees.add(new Employee123("Alice", 25, 60000));

		employees.add(new Employee123("Bob", 28, 70000));
		
		StringBuilder sb=new StringBuilder();
	

		List<Employee123> collect = employees.stream().filter(e -> e.getAge() >= 25).map(e -> {
			e.setSalary(e.getSalary() + e.getSalary() * 0.10);
			return e;
		}).collect(Collectors.toList());
		System.out.println(collect);
		employees.sort(Comparator.comparing(Employee123::getEmpName).thenComparing(Employee123::getAge));
		System.out.println(employees);
		List<String> list = Arrays.asList("apple", "banana", "orange", "papaya");
		list.contains(null);
		List<String> collect2 = list.stream().map(str->str.substring(0, 1).toUpperCase()+str.substring(1))
				.collect(Collectors.toList());
		System.out.println(collect2);
		System.out.println(list);
		employees.stream().collect(Collectors.groupingBy(Employee123::getEmpName,
				Collectors.maxBy(Comparator.comparing(Employee123::getSalary).reversed())))
		.entrySet().forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
		list.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", ")))
				.forEach((k, v) -> System.out.println(k + " " + v));
		
		
		List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
		
		List<Integer> collect3 = listOfLists.stream().flatMap(l->l.stream()).collect(Collectors.toList());
		System.out.println(collect3);
		
	}

}
