package com.tj.ex6atmcardn;

public class Main {
	public static void main(String[] args) {
		
		Account obj = new Account(1000);
		
		ATM_action card_mom = new ATM_action(obj, 0);
		ATM_action card_dad = new ATM_action(obj, 0);
		
		Thread mom = new Thread(card_mom,"����");
		Thread dad = new Thread(card_dad,"�ƺ�");
		
		mom.start();
		dad.start();

	}
}
