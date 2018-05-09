package com.tj.ex6atmcardn;

public class ATM_action implements Runnable {
	private Account obj; // °èÁÂ
	private int toggle = 0;

	public ATM_action(Account obj, int toggle) {
		this.obj = obj;
		this.toggle = toggle;
	}

	@Override
	public void run() { // deposit() <-> whitdrow() ¹Ýº¹
		for (int i = 0; i < 5; i++) {
			if (toggle == 1) {
				obj.deposit(1000, Thread.currentThread().getName());
				toggle = 0;
			} else {
				obj.whitdrow(1000, Thread.currentThread().getName());
				toggle = 1;
			}// if
		}// for
	}// run()

}
