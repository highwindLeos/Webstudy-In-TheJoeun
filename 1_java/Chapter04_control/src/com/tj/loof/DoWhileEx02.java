package com.tj.loof;

import java.io.IOException;

// 짝수를 입력받아 출력.(단, 홀수를 입력시 다시 입력받음)
public class DoWhileEx02 {

	public static void main(String[] args) throws IOException {

		int num;
		do {
			System.out.println("원하는 짝수를 입력해주세요.");
			// 0 을 누르면 입력되는 아스키 코드는 '0'(48), Enter(13, 10)
			// 0 (48) 1(49) 2(50)
			num = System.in.read()-'0'; // 키보드 입력키의 아스키 코드 하나를 가져온다.
			System.in.read();	// 아스키코드값을 가져만 옴.
		} while ((num % 2) == 1 || (num%2) == -1); // 입력된 값이 홀수 이면 true?

		System.out.println("입력한 짝수는 " + num + " 입니다.");

	}// main
}
