package com.tj.ex4lib;

import java.util.Scanner;

// �̸� ���� �Է� �ް� �����ϸ� ���� �Է�. 
public class TestMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("�̸���?");
		String name = sc.next();
		
		String nickName = getNickName(sc);
		
		System.out.print("���̴�?");
		int age = sc.nextInt();
		
		System.out.print("[�̸�] : " + name + "\t[����] : " + nickName + "\t[����] : " + age);
		
		sc.close();
	}

	private static String getNickName(Scanner sc) {
		
		System.out.print("������?");
		String nickname = sc.next();
		
		return nickname;
	}

}
