package com.javatechie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
	private int salary;
	private String name;
	private int age;

	public Employee(int salary, String name, int age) {
		super();
		this.salary = salary;
		this.name = name;
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", name=" + name + ", age=" + age + "]";
	}

}

public class PartitionByJava {

	public static void main(String[] args) {

		List<Employee> emp = new ArrayList<>();
		emp.add(new Employee(100, "aa", 50));
		emp.add(new Employee(150, "bb", 18));
		emp.add(new Employee(100, "cc", 20));
		emp.add(new Employee(200, "dd", 25));
		emp.add(new Employee(300, "ee", 19));
		emp.add(new Employee(50, "ff", 55));
		emp.add(new Employee(500, "gg", 35));

		Map<Boolean, List<Employee>> collect = emp.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() >= 300));
		
		
		System.out.println("Base on salary :{}" + collect);
		Map<Boolean, List<Employee>> collect2 = emp.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		System.out.println("Base on age :{}" + collect2);

	}
}
