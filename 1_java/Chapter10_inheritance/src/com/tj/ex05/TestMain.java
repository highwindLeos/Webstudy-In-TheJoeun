package com.tj.ex05;

public class TestMain {

	public static void main(String[] args) {
		ParentClass p = new ParentClass();
		ChildClass c = new ChildClass();
		
		p.method1();
		p.method2();
		
		c.method1();
		c.method2();
		c.method3();
	}

}
