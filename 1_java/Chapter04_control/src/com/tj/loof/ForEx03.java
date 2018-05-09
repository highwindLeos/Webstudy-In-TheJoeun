package com.tj.loof;

// 15 ~ 50 가지 한줄에 5개 씩 출력.
public class ForEx03 {
	public static void main(String[] args) {
		for (int i = 15; i <= 50; i++) {

			if ((i % 5) == 4) { // 5로 나눗었을때 (끝이 4 9) 경우 줄바꿈.
				System.out.print(i + "\n");
			} else {
				System.out.print(i + "\t");
			} // end if
			
		} // end for
	} // main
} // class