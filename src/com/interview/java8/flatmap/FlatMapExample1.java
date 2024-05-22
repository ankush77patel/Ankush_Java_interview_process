package com.interview.java8.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlatMapExample1 {
	public static void main(String[] args) {
		 Developer o1 = new Developer();
	        o1.setName("mkyong");
	        o1.addBook("Java 8 in Action");
	        o1.addBook("Spring Boot in Action");
	        o1.addBook("Effective Java (3nd Edition)");

	        Developer o2 = new Developer();
	        o2.setName("zilap");
	        o2.addBook("Learning Python, 5th Edition");
	        o2.addBook("Effective Java (3nd Edition)");

	        List<Developer> list = new ArrayList<>();
	        list.add(o1);
	        list.add(o2);
	        
	        String s1="abcdedd_dd";
	        String s3="e";
	        System.out.println(s1.contains(s3));
	        
	        String[] array = {"apple", "banana", "orange"};
	        String join = String.join("# ", array);
	        System.out.println(join);
	        Optional<Object> empty = Optional.empty();
	        
	        Optional<Object> ofNullable = Optional.ofNullable(null);
	        System.out.println(empty);
	        System.out.println(ofNullable);
	        
	      list.stream().flatMap(e->e.getBook().stream()).filter(e-> e.equals("Effective Edition)"))
	      .findFirst().ifPresentOrElse(e->System.out.println("This is present"),()->System.out.println("no"));
	        
	        
	        
	        List<String> collect = list.stream().flatMap(e->e.getBook().stream()).filter(e-> !e.equals("Effective Java (3nd Edition)")).collect(Collectors.toList());
	        System.out.println(collect);
		}
}
