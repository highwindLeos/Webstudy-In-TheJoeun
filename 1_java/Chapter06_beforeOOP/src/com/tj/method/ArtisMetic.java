package com.tj.method;

// ���� �ϴ� �Լ��鸸 ��Ƴ��� Class
public class ArtisMetic {
	
	public int sum(int from, int to) {
		int resulte = 0;
		for (int i = from; i <= to; i++) {
			resulte += i;
		}
		return resulte;
	}// sum()

	public String evenOdd(int value) {
		String resulte = value % 2 == 0 ? "¦�� �Դϴ�." : "Ȧ�� �Դϴ�.";
		return resulte;
	} //evenOdd()

	public int abs(int value) {
		int resulte = (value >= 0) ? value : -value;
		// if (value >= 0) {
		// resulte = value;
		// } else {
		// resulte = -value;
		// } // ���� �ϰ�� - �� ���ؼ� ����� ��ȯ.
		return resulte;
	} // abs()
}
