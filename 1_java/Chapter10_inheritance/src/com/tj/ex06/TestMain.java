package com.tj.ex06;

public class TestMain {

	public static void main(String[] args) {
		ChildClass c = new ChildClass();

		System.out.println(c.getcStr());
		System.out.println(c.getpStr());

		c.getPapaName();
		c.getMamaName();
	}

}
