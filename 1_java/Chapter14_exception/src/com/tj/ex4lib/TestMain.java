package com.tj.ex4lib;

import java.util.Scanner;

// 이름 나이 입력 받고 여차하면 별명 입력. 
public class TestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("이름은?");
		String name = sc.next();
		
		String nickName = getNickName(sc);
		
		System.out.print("나이는?");
		int age = sc.nextInt();
		
		System.out.print("[이름] : " + name + "\t[별명] : " + nickName + "\t[나이] : " + age);
		
		sc.close();
	}

	private static String getNickName(Scanner sc) {
		
		System.out.print("별명은?");
		String nickname = sc.next();
		
		return nickname;
	}

}
