package com.tj.ex3;

public class AccountMain {

	public static void main(String[] args) {
		Account leos = new Account("11-11", "Days");
		Account kim = new Account("11-12", "�豸��", 20000);
		Account lee = new Account();
		
		lee.setAccountNo("11-13"); lee.setOwnerName("�̸���");
		System.out.println("leos �ܾ� : "+leos.getBalance()+"��");
		System.out.println("kim �ܾ� : "+kim.getBalance()+"��");
		System.out.println("lee �ܾ� : "+lee.getBalance()+"��");
		
		leos.deposit(10000);
		
		int money = kim.whitdraw(20000);
		if(money > 0) {
			System.out.println(kim.getOwnerName() + " �� "+ money + "�� ����Ͽ� �ܾ� : " + kim.getBalance());
		}
	}

}
