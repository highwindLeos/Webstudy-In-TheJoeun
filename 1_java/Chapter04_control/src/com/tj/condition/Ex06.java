package com.tj.condition;

import java.util.Scanner;

// ���� = 0  ���� = 1 �� = 2 �� �ϳ��� ������ �߻��Ѵ�.
public class Ex06 {
	public static void main(String[] args) {
		// �⺻ API
		// Math.random() : 0 ~ 1 ������ double�Ǽ�
		// Math.random()*3 : 0 < 3 ������ double�Ǽ�
		int computer = (int) (Math.random() * 3);

		if (computer == 0) {
			System.out.println("����");
		} else if (computer == 1) {
			System.out.println("����");
		} else if (computer == 2) {
			System.out.println("��");
		}
	}
}
