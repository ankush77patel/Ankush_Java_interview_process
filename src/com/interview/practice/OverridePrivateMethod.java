package com.interview.practice;
/*
 * Private method can not be override and it is not accessible from out side the class
 * so if you uncomment the line 21 it will throw compile time error.
 */
class Override1 {
	private void m1() {
		System.out.println("This is Override1 M1 Method");
	}
}

class Override2 extends Override1 {
	private void m1() {
		System.out.println("This is Override2 M1 Method");
	}
}

public class OverridePrivateMethod {
	public static void main(String[] args) {
		Override1 o1 = new Override2();
		//o1.m1();
	}
}
