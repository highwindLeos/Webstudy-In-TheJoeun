package com.tj.ex0trycatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int j = 0;
		
		System.out.println("��Ģ������ �Ұ̴ϴ�.");
		
		do {
			System.out.println("ù��° ��?");
			try {
				i = sc.nextInt(); //*
				break;
			} catch (InputMismatchException e) {
				System.out.println("���� �Է��ϼ��� �ȱ׷��� 0����");
				sc.nextLine();
			}
		}while(true); // ���� �Է��Ҷ� ���� ��� �ݺ�
		
		System.out.println("�ι�° ��?");
		
		try {
			j = sc.nextInt(); //*
			System.out.println("i * j = " + (i * j));
			System.out.println("i / j = " + (i / j)); //*
		} catch (InputMismatchException e) {
			System.out.println("���� �Է��ϼ��� �ȱ׷��� 0����");
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
			
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));

		System.out.println("�̻��Դϴ�.");
		sc.close();
	}
}
