package com.tj.loof;

public class ForEx07 {

	public static void main(String[] args) {
		int total = 0; // 합을 누적.
		for (int i = 1; i <= 10; i+=2) { // 1~10 까지 홀수 합.
			total += i; 
		} // end for
		System.out.println("1~ 10 까지의 홀수의 합은 : " + total);
	}
}
