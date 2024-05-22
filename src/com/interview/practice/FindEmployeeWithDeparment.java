package com.interview.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee123 {
	int id;
	String name;
	String deparment;
	boolean isAcitve;

	public Employee123(int id, String name, String deparment, boolean isAcitve) {
		super();
		this.id = id;
		this.name = name;
		this.deparment = deparment;
		this.isAcitve = isAcitve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public boolean isAcitve() {
		return isAcitve;
	}

	public void setAcitve(boolean isAcitve) {
		this.isAcitve = isAcitve;
	}

	@Override
	public String toString() {
		return "Employee123 [id=" + id + ", name=" + name + ", deparment=" + deparment + ", isAcitve=" + isAcitve + "]";
	}

}

public class FindEmployeeWithDeparment {

	public static void main(String[] args) {
		List<Employee123> employees = Arrays.asList(new Employee123(1, "Ankush", "HR", true),
				new Employee123(1, "aa", "HR", false), new Employee123(1, "Ankush", "it", true),
				new Employee123(3, "Priyanka", "HR", true));
		List<String> activeEmp = employees.stream().filter(e -> "HR".equals(e.getDeparment()) && e.isAcitve())
				.map(e -> e.getName().toUpperCase()).collect(Collectors.toList());

		System.out.println(activeEmp);
		
		Optional<Employee123> op=null;
	}
}
