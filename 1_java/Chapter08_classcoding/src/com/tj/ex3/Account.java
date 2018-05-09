package com.tj.ex3;
/*
 데이터 속성 : 계좌 번호 (accountNo : String)
 				예금주 (ownerName : String)
 				잔액 (balance : int)
 
 기능 (메소드) : 예금하다 (void deposit(int))
 				인출하다 (int whitdraw(int))
 				잔액조회 (int getBalance())
*/
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {
		System.out.println("계좌 오픈 감사합니다. 계좌 번호 이름 입력요망");
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println("계좌 오픈 감사합니다. 잔액 " + balance);
	}
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		balance = 0;
		System.out.println("계좌 오픈 감사합니다.");
	}
	// 여기까지 생성자 메소드. ()
	
	public void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.println("감사 합니다. : " + money +"원 입금하여 잔액이 " + balance +"원 입니다.");
		}else {
			System.out.println("대출은 안되요. 대출창구로 가 보세요.");
		}
	}
	
	public int whitdraw(int money) { // 인출
		if(balance >= money) { // 인출금이 잔액보다 작을때만 인출. (true) 
			balance = balance - money; // 인출
			System.out.println("거래 감사 합니다. : " + money +"원 출금하여 잔액이 " + balance +"원 입니다.");
			return money;
		} else {
			System.out.println("잔액이 부족합니다. 인출 불가.");
			return 0;
		}
	}
	// getter setter method
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

	public int getBalance() { // 잔액조회 함수.
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
