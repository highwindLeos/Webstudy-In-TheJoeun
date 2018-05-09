package com.tj.ex3account;

public class Account {
	private String account;
	private String ownerName;
	private int balance;
	// ������
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
	// �޼ҵ�
	public void deposit(int amount) {
		balance += amount;
		System.out.println(ownerName + "���� " + amount + "�� �����Ͽ� �ܾ� " + balance);
	}

	public void whitdraw(int amount) throws Exception {
		if (balance < amount) { // ����ݾ��� ���ݾ׺��� ũ�ٸ�
			// ���� ���� �߻���Ŵ
			throw new Exception( account + "�����ϱ⿡�� �ܾ�(" + Math.abs(balance - amount) + ")�� �����մϴ�."); // ���� �޼��� �ۼ�
		}
		balance -= amount;
		System.out.println(ownerName + "���� " + amount + "�� �����Ͽ� �ܾ�" + balance);
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
