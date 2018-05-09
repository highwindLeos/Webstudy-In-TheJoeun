package com.tj.ex05tostring;

public class CardMain {

	public static void main(String[] args) {
		Card you = new Card('¡ß', 1);
		Card me = new Card('¢À', 11);
		Card him = new Card('¢¾', 2);

		System.out.println(you);
		System.out.println(me);
		System.out.println(him);
	}

}
