package com.tj.loof;

import java.util.Scanner;

// ��ǻ�Ͱ� ���� Lotto ��ȣ �� ���ߴ� ����.
// 2�ܰ� : .
public class DoWhileEx04 {

	public static void main(String[] args) {
		// 0.0 <= Math.random() �Ǽ� < 1
		// 0.0 <= Math.random()*45<45
		// 0 <= (int)(Math.random()*45<45
		// 1 <= (int)(Math.random()*45)+1 < 46
		int lotto, userNum;
		int min = 1, max = 45; // �ּҰ� �ִ밪

		lotto = (int) (Math.random() * 45) + 1; // 1~45

		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Lotto ��ȣ�� ���纸����." + min + " ���� " + max + "���� �Է����ּ���.");
			userNum = sc.nextInt();
			
			if(userNum < min || userNum > max) {
				System.out.println("���� �ȿ� ���� �Է��ϼ���.");
			}else if (userNum == lotto) {
				break;
			} else if (userNum > lotto) {
				max = userNum - 1;
			} else if (userNum < lotto) {
				min = userNum + 1;
			}
		} while (true);
		System.out.println("���߼̽��ϴ�!! Lotto  ��ȣ�� " + lotto + " �Դϴ�.");
	}// main
}
