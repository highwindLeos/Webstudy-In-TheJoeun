package com.tj.ex3;

public class AccountMain {

	public static void main(String[] args) {
		Account leos = new Account("11-11", "Days");
		Account kim = new Account("11-12", "±è±¸¶ó", 20000);
		Account lee = new Account();
		
		lee.setAccountNo("11-13"); lee.setOwnerName("ÀÌ¸»³â");
		System.out.println("leos ÀÜ¾× : "+leos.getBalance()+"¿ø");
		System.out.println("kim ÀÜ¾× : "+kim.getBalance()+"¿ø");
		System.out.println("lee ÀÜ¾× : "+lee.getBalance()+"¿ø");
		
		leos.deposit(10000);
		
		int money = kim.whitdraw(20000);
		if(money > 0) {
			System.out.println(kim.getOwnerName() + " ´Ô "+ money + "¿ø Ãâ±İÇÏ¿© ÀÜ¾× : " + kim.getBalance());
		}
	}

}
