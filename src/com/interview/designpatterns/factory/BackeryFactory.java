package com.interview.designpatterns.factory;

public class BackeryFactory {
	public static Cake createCake(String type) {
		Cake cake;
		switch(type) {
		case "Chocolate": cake= new Chocolate();
			break;
		case "Venilla": cake= new Venilla();
			break;
		default: cake=null;
		}
		return cake;
	}
}
