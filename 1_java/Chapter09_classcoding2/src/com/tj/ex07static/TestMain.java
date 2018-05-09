package com.tj.ex07static;

public class TestMain {

	public static void main(String[] args) {
		
		System.out.println("현제 엄마 지갑 " + MomPouch.money);
		
		Child first = new Child("첫째아들");
		Child second = new Child("둘째아들");
		Child third = new Child("셋째아들");
		
		first.takeMoney(100);
		System.out.println("현제 엄마 지갑 " + MomPouch.money);
		second.takeMoney(100);
		System.out.println("현제 엄마 지갑 " + MomPouch.money);
		third.takeMoney(100);
		System.out.println("현제 엄마 지갑 " + MomPouch.money);

	}

}
