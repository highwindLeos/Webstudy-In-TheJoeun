package com.tj.ex13account;

public class TestMain {

	public static void main(String[] args) {
		Account a1 = new Account("111-111", "홍길동");
		a1.printAccount();
		Account a2 = new Account("111-112","홍길순", 1000);
		a2.deposite(-10);
		a2.deposite(10000);
		a2.whitdraw(1000);
		a2.printAccount();
		
		System.out.println("- - - 직 불 카 드 T E S T- - -");
		
		CheakingAccount c1 = new CheakingAccount("222-111", "Leos", "1111-1111-1111-1111");
		CheakingAccount c2 = new CheakingAccount("111-222", "Days", 20000, "2222-2222-2222-2222");
		
		c1.deposite(1000);
		c1.pay("1111-1111-1111-1111", 50);
		
		c2.pay("2222-2222-2222-2222", 110000);

		System.out.println("- - - 신 용 카 드 T E S T- - -");

		CheakingAccount credit1 = new CreditLineAccount("11-11", "leos", 100, "1111-1111-1111-1111", 1000);
		credit1.pay("1111-1111-1111-1111", 100);
		credit1.pay("1111-1111-1111-1111", 500);
		
	}

}
