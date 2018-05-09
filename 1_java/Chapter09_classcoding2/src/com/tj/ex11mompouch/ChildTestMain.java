package com.tj.ex11mompouch;

public class ChildTestMain {

	public static void main(String[] args) {
		System.out.println("엄마 돈은 :" + MomPouch.MONEY + " 원");
//		MomPouch m = new MomPouch();
//		System.out.println("엄마 돈은 :" + m.MONEY + " 원");  // static 은 꼭 객체로 접근하지 않아도 된다고 경고를 보낸다.	
		
		Child first = new Child("첫째아들 Lee");
		Child second = new Child("셋째아들 Im");
		Child third = new Child("셋째아들 Non");

		first.takeMoney(100);
		System.out.println("잔액 : " + MomPouch.MONEY);
		
		second.takeMoney(100);
		System.out.println("잔액 : " + MomPouch.MONEY);
		
		third.takeMoney(100);
		System.out.println("잔액 : " + MomPouch.MONEY);

	}

}
