package com.interview.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class A{
	public Number m1(Integer i,Integer i2) {
		System.out.println("parrent");
		return i;
	}
}

class B extends A{
	public Integer  m1(Integer i,Integer i2) {
		System.out.println("child");
		return i;
	}
}

class SuperClass
{
    void superClassMethod(Number n)
    {
        System.out.println("From Super Class");
    }
}
 
class SubClass extends SuperClass
{
    void superClassMethod(Double d)
    {
        System.out.println("From Sub Class");
    }
}

public class StringJoinMethod {
	
	
	public static void main(String[] args) {
		StringJoinMethod stringJoinMethod = new StringJoinMethod();
		List<String> list=Arrays.asList("GG","DD","EE","TT");
		Map<String,Object> map=new HashMap<>();
		List<String> emptyList=new ArrayList<>();
		map.put("KK", "");
		emptyList.addAll(list);
		
		 SubClass sub = new SubClass();
		 
	        sub.superClassMethod(123321);
		
		A a=new B();
		a.m1(10, 20);
		//stringJoinMethod.m1(null, null);
		
		
	//String d=	list.stream().filter(s->map.containsKey(s)).findFirst().get();
		
	String s="12445";
	m1(s);
		System.out.println("main s"+s);
	}
	
	
	public static void m1(String s) {
		s=null;
		System.out.println(s);
	}
}
