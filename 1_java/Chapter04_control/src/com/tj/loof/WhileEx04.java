package com.tj.loof;

public class WhileEx04 {

	public static void main(String[] args) {
		int i = 1; //반복 변수
		int total = 0; // 누적 변수
		while(i <= 100) {
			if((i%3) == 0) {
				total += i;
			} //if
			i++;
		}//while
		System.out.println("1~100 까지 3의 배수들 누적 + "+total);
	}// main
}
