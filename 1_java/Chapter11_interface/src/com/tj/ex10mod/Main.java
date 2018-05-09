package com.tj.ex10mod;

import javax.jws.soap.SOAPBinding.Use;

public class Main {
	public static void main(String[] args) {
		A a= new A();
		B b = new B();
		
		User user = new User();
		user.aorbUse(a);
		user.aorbUse(b);
	}
}
