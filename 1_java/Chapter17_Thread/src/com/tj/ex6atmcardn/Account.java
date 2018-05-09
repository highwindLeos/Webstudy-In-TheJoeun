package com.tj.ex6atmcardn;

public class Account {
	private int balence; // 잔액.

	public Account(int balence) {
		this.balence = balence;
	}

	public synchronized void deposit(int amount, String who) { // 한 작업이 마칠때 까지 다른 작업은 시작되지 않음.
		System.out.println("★" + who + "가 입금시작");
		balence += amount;
		System.out.println(who + "가 " + amount + "입금하여 잔액 " + balence);
		System.out.println("★--" + who + "가 입금 완료 --★");
	}
	
	public synchronized void whitdrow(int amount, String who) { // 한 작업이 마칠때 까지 다른 작업은 시작되지 않음.
		System.out.println("★" + who + "가 출금시작");
		if (balence >= amount) {
			balence -= amount;
			System.out.println(who + "가 " + amount + "출금하여 잔액 " + balence);
		} else {
			System.out.println("잔액 : "+ balence + " 잔액이 부족합니다.");
		}
		System.out.println("★--" + who + "가 출금 완료 --★");
	}

}
