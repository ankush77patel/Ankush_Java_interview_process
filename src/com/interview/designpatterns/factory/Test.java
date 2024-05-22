package com.interview.designpatterns.factory;

public class Test {
public static void main(String[] args) {
	Cake createCake = BackeryFactory.createCake("Venilla");
	Cake createCake2 = BackeryFactory.createCake("Chocolate");
	createCake.bake();
	createCake2.bake();
}
}
