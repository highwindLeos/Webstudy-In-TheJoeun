package com.tj.ex03overloading;

public class TestMain {
	public static void main(String[] args) {
		// obj.i1 = 20 / obj.i2 = 20
		OverloadingTest obj1 = new OverloadingTest("20");
		OverloadingTest obj2 = new OverloadingTest();
		OverloadingTest obj3 = new OverloadingTest(20);
		OverloadingTest obj4 = new OverloadingTest(10,5);
		
		System.out.println("obj1 연산결과   : " + obj1.calculate());
		System.out.println("obj2 연산결과 * : " + obj2.calculate('*'));
		System.out.println("obj2 연산결과 @ : " + obj2.calculate('@'));

	}
}
