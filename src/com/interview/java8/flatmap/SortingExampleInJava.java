package com.interview.java8.flatmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
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
		return "Employee [name=" + name + ", age=" + age + "]";
	}

}

public class SortingExampleInJava {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Bob", 35));
		employees.add(new Employee("John", 30));
		employees.add(new Employee("Alice", 25));
		employees.add(new Employee("Adam", 20));
		employees.add(new Employee("Baby", 25));
		
		ConcurrentHashMap<String,String> hs=new ConcurrentHashMap<>();
		
		System.out.println(employees);
		Collections.sort(employees, Comparator.comparing(Employee::getName));
		System.out.println(employees);
		
		Collections.sort(employees,Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
		System.out.println(employees);

	}
}
