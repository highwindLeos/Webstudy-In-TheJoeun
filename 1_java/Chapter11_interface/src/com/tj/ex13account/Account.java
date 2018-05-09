package com.tj.ex13account;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	// ������
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
	
	// �޼ҵ�
	public void deposite(int amount) {
		if (amount <= 0) {
			System.out.println("1�� �̻� �����ϼž��մϴ�.");
			return;
		}
		balance += amount;
		System.out.println(ownerName +"���� : " + amount +"�� �����ؼ� �ܾ�" + balance);
	} // ����
	
	// ���ϰ� : ����� �ݾ� / �Ű����� amount : �����ϰ��� �ϴ� �ݾ�.
	public int whitdraw(int amount) { // ������
		int resulte = amount;
		if(balance < amount) {
			System.out.println("�ܾ��� �����մϴ�.");
			resulte = 0;
		} else {
			balance -= amount;
			System.out.println(ownerName + "���� : " + amount +"�� �����Ͽ� �ܾ� "+ balance);
		}
		return resulte;
	}
	
	public void printAccount() {
		System.out.print("[���¹�ȣ] : " + accountNo);
		System.out.print("\t[������] : " + ownerName);
		System.out.println("\t[��  ��] : " + balance);
	} // ��� �Լ�

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

