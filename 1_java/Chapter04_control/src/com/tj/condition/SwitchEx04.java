package com.tj.condition;

import java.util.Scanner;

public class SwitchEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ����ΰ��� : 1 ~ 12��");
		int month = sc.nextInt();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("�ܿ��̳׿� ��������.!!"); break;
		case 3: case 4: case 5:
			System.out.println("���̳׿� �̼����� ����!!"); break;
		case 6: case 7: case 8:
			System.out.println("�����̳׿� �ٴٰ���!!"); break;
		case 9: case 10: case 11:
			System.out.println("�����̳׿� ��ǳ���氡��!!"); break;
		default:
			System.out.println("1 ~ 12 ������ �Է��϶�.");
		}
		sc.close(); 
	}

}
