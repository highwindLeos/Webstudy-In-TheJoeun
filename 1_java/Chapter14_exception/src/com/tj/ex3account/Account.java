package com.tj.ex3account;

public class Account {
	private String account;
	private String ownerName;
	private int balance;
	// 생성자
	public Account(String account, String ownerName) {
		super();
		this.account = account;
		this.ownerName = ownerName;
	}

	public Account(String account, String ownerName, int balance) {
		super();
		this.account = account;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	// 메소드
	public void deposit(int amount) {
		balance += amount;
		System.out.println(ownerName + "님이 " + amount + "원 예금하여 잔액 " + balance);
	}

	public void whitdraw(int amount) throws Exception {
		if (balance < amount) { // 인출금액이 예금액보다 크다면
			// 강제 예외 발생시킴
			throw new Exception( account + "인출하기에는 잔액(" + Math.abs(balance - amount) + ")이 부족합니다."); // 예외 메세지 작성
		}
		balance -= amount;
		System.out.println(ownerName + "님이 " + amount + "원 인출하여 잔액" + balance);
	}

	@Override
	public String toString() {
		return "[account=" + account + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	//setter getter
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
