package com.amber.test;

public class A {
	protected int a = 3;
	public A() {
		a = 5;
	}
	public static void main(String[] args) {
		new C();
	}
}

class B extends A {
	protected int b = 6;
	public B() {
		b = 10;
	}
	
}

class C extends B {
	protected int c = 4;
	public C() {
		c = 8;
		print();
	}
	public void print() {
		System.out.println("" + a + "   " + b + "   " + c);
	}
}
