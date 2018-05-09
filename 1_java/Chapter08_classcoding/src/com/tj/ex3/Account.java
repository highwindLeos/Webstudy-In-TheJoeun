package com.tj.ex3;
/*
 ������ �Ӽ� : ���� ��ȣ (accountNo : String)
 				������ (ownerName : String)
 				�ܾ� (balance : int)
 
 ��� (�޼ҵ�) : �����ϴ� (void deposit(int))
 				�����ϴ� (int whitdraw(int))
 				�ܾ���ȸ (int getBalance())
*/
public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	
	public Account() {
		System.out.println("���� ���� �����մϴ�. ���� ��ȣ �̸� �Է¿��");
	}
	
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println("���� ���� �����մϴ�. �ܾ� " + balance);
	}
	
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		balance = 0;
		System.out.println("���� ���� �����մϴ�.");
	}
	// ������� ������ �޼ҵ�. ()
	
	public void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.println("���� �մϴ�. : " + money +"�� �Ա��Ͽ� �ܾ��� " + balance +"�� �Դϴ�.");
		}else {
			System.out.println("������ �ȵǿ�. ����â���� �� ������.");
		}
	}
	
	public int whitdraw(int money) { // ����
		if(balance >= money) { // ������� �ܾ׺��� �������� ����. (true) 
			balance = balance - money; // ����
			System.out.println("�ŷ� ���� �մϴ�. : " + money +"�� ����Ͽ� �ܾ��� " + balance +"�� �Դϴ�.");
			return money;
		} else {
			System.out.println("�ܾ��� �����մϴ�. ���� �Ұ�.");
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

	public int getBalance() { // �ܾ���ȸ �Լ�.
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
