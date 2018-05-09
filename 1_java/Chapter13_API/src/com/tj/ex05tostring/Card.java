package com.tj.ex05tostring;

public class Card {
	private char kind; // ♥ ◆ ♣ ♠
	private int num; // A, 2~9, jack queen king

	public Card(char kind, int num) { // 생성자
		this.kind = kind;
		this.num = num;
	}

	// 메소드

	@Override // java.lang.Object 오버라이드.
	public String toString() {
		String resulte = kind + " ";
		
		if (num == 1) {
			resulte += "A";
		} else if (num >= 2 && num <= 9) { // 2~9 사이 값이라면.
			resulte += num;
		} else if (num == 10) {
			resulte += "Jack" + num;
		} else if (num == 11) {
			resulte += "Queen" + num;
		} else if (num == 12) {
			resulte += "King" + num;
		}

		return resulte;
	}

}
