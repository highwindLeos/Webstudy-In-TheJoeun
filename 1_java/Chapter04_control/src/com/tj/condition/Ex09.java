package com.tj.condition;

import java.util.Scanner;

// ������ �Է� �޾Ƽ� ������ ����ϴ� ���α׷�.
public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "Leo";

		System.out.println("������ �Է����ּ���.");
		int score = sc.nextInt();
		
		if (score >= 90 && score <= 100) {
			System.out.println("A���� \t ���߾��");
		} else if (score >= 80 && score <= 90) {
			System.out.println("B���� \t �߱��߳�?");
		} else if (score >= 70 && score <= 80) {
			System.out.println("C���� \t �״���?");
		} else if (score >= 60 && score <= 70) {
			System.out.println("D���� \t ���� ������?!");
		} else if (score >= 0 && score <= 60) {
			System.out.println("F���� \t ���� ������!?");
		} else {
			System.out.println("��ȿ�� ������ �ƴմϴ�.");
		}
		sc.close(); // ��ĳ�� ����

	}

}
