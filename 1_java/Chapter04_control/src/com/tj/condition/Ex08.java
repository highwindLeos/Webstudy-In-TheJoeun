package com.tj.condition;
// ��Ű� ��ǻ�Ͱ� ���� ���� �� ���� ���� �̰���� ���.

import java.util.Scanner;

// ���� ���°� ��ǻ�ʹ� ���´��� ��µ� ���ش�. 
public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� ���� �����ϼ��� : ���� (0) , ���� (1), �� = (2)");
		int human = sc.nextInt();
		
		String humanCrad="";
		String computerCard="";
		
		if (human == 0) {
			humanCrad = "����";
		} else if (human == 1) {
			humanCrad = "����";
		} else if (human == 2) {
			humanCrad = "��";
		} else {
			System.out.println("0~2 ������ ���� �Է����ּ���");
			System.exit(0);
		}
		// Math.random() : 0 ~ 1 ������ double�Ǽ�
		// Math.random()*3 : 0 < 3 ������ double�Ǽ�
		int computer = (int)(Math.random() * 3); //0~3 ������ ����
		
		if (computer == 0) {
			computerCard = "����";
		} else if (computer == 1) {
			computerCard = "����";
		} else if (computer == 2) {
			computerCard = "��";
		} 

		if ((human + 2) % 3 == computer) {
			System.out.printf("����� : %s \n��ǻ�ʹ� : %s , \n����� �̰���ϴ�.",humanCrad ,computerCard);
		} else if( human == computer ) {
			System.out.printf("����� : %s \n��ǻ�ʹ� : %s , \n�츮�� �����ϴ�.",humanCrad ,computerCard);
		} else {
			System.out.printf("����� : %s \n��ǻ�ʹ� : %s , \n����� �����ϴ�.(��ǻ�� ��)",humanCrad ,computerCard);
		}
		
		sc.close();
	}
}
