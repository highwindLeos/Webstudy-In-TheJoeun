package com.tj.ex13account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	// 생성자
	public Account() {}

	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	public Account(String accountNo, String ownerName, int balance) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	// 메소드
	public void deposite(int amount) {
		if (amount <= 0) {
			System.out.println("1원 이상 저금하셔야합니다.");
			return;
		}
		balance += amount;
		System.out.println(ownerName +"계좌 : " + amount +"원 저금해서 잔액" + balance);
	} // 예금
	
	// 리턴값 : 인출된 금액 / 매개변수 amount : 인출하고자 하는 금액.
	public int whitdraw(int amount) { // 인출기능
		int resulte = amount;
		if(balance < amount) {
			System.out.println("잔액이 부족합니다.");
			resulte = 0;
		} else {
			balance -= amount;
			System.out.println(ownerName + "계좌 : " + amount +"원 인출하여 잔액 "+ balance);
		}
		return resulte;
	}
	
	public void printAccount() {
		System.out.print("[계좌번호] : " + accountNo);
		System.out.print("\t[예금주] : " + ownerName);
		System.out.println("\t[잔  액] : " + balance);
	} // 출력 함수

	// getter setter
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

