package com.tj.ex3account;

public class AccountMain {

	public static void main(String[] args) {
		Account ac1 = new Account("111-1111", "ȫ�浿");
		Account ac2 = new Account("222-2222", "�ڱ浿", 2000);
		
		ac1.deposit(10000);
		System.out.println(ac1); // tostring();
		
		ac2.deposit(10000);
		
		try {
			ac1.whitdraw(2000);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		try {
			ac1.whitdraw(20000);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage()); // throw new Exception(); ���� ������ �޼����� �����ͼ� �������
		}
	}

}
