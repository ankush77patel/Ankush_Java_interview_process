package com.javatechie;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
	private  String name;
	    int grade;

	    public Student(String name, int grade) {
	        this.name = name;
	        this.grade = grade;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getGrade() {
	        return grade;
	    }
	    
	    
	    @Override
		public String toString() {
			return "Student [name=" + name + ", grade=" + grade + "]";
		}




		public class Main {
	        public static void main(String[] args) {
	            List<Student> students = Arrays.asList(
	                new Student("Alice", 90),
	                new Student("Bob", 85),
	                new Student("Charlie", 90),
	                new Student("David", 80)
	            );
	            Map<Integer,List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getGrade));
	            System.out.println(collect);
	         
	        }
	    }

}
