package com.tj.method;

// 셈을 하는 함수들만 모아놓은 Class
public class ArtisMetic {
	
	public int sum(int from, int to) {
		int resulte = 0;
		for (int i = from; i <= to; i++) {
			resulte += i;
		}
		return resulte;
	}// sum()

	public String evenOdd(int value) {
		String resulte = value % 2 == 0 ? "짝수 입니다." : "홀수 입니다.";
		return resulte;
	} //evenOdd()

	public int abs(int value) {
		int resulte = (value >= 0) ? value : -value;
		// if (value >= 0) {
		// resulte = value;
		// } else {
		// resulte = -value;
		// } // 음수 일경우 - 를 곱해서 양수로 전환.
		return resulte;
	} // abs()
}
