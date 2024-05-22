package com.javatechie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {


    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725"),100000d,"US"),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947"),150000d,"INDIA"),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236"),200000d,"FRANCE"),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"),300000d,"BRAZIL"),
                new Customer(105, "Ankush", "ankush@gmail.com", Arrays.asList("389246829368", "948609469"),500000d,"INDIA")
                
        ).collect(Collectors.toList());
    }


}
