package com.tj.ex1;

public class SqureMenu {

	public static void main(String[] args) {
		Squre s1 = new Squre();

		s1.setSide(25); // s1.side = 25;
		System.out.println("s1 ÀÇ ³ĞÀÌ´Â " + s1.area());
		
		Squre s2 = new Squre(10);
		System.out.println("s2 ÀÇ ³ĞÀÌ´Â " + s2.area());

	}

}
