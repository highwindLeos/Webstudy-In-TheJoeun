package com.tj.ex05market;

public class Main {
	public static void main(String[] args) {
		Customer customer = new Customer("�̽���", "010-0000-0977");
		
		System.out.println(customer.outString());
		
		customer.phoneChange("010-9999-00000");
		
		System.out.println("Customer�� ���ǻ��");
		customer.buy(10000);
		customer.buy(100000);
		
		System.out.println("* * * Customer ��ü ��� * * *");
		System.out.println(customer.outString());
		
		Vvip vvip = new Vvip("�̸�ȭ", "010-8888-8888", "01-01");
		
		System.out.println(vvip.outString());
		vvip.buy(30000);
		vvip.phoneChange("010-7777-7777");
		System.out.println(vvip.outString());
		vvip.buy(100000);
		System.out.println(vvip.outString());

		
	}
}
