package com.tj.Example;

import java.util.Scanner;

public class Q5 { //주민번호 7번째 자리를 입력해서 여자인지 남자인지 출력하는 과제.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.println("주민 번호 7번째 자리를 입력해주세요.");
		int num = sc.nextInt();
		
		if (num == 1 || num == 3) {
			System.out.println("남성입니다.");
		} else if (num == 2 || num == 4) {
			System.out.println("여성입니다.");
		} else {
			System.out.println("주민번호 7번째는 1,2,3,4 만 올수 있습니다.");
		}
		
	}

}
