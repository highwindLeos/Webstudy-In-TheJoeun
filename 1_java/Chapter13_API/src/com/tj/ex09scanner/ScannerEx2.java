package com.tj.ex09scanner;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸��� ?");
		// white space ('\n', ' ' '\t') �ձ����� ������ ������
		String name = scanner.nextLine(); // nextLine(); ���鵵 �����ؼ� �Է¹��� �� �ִ�.
		
		System.out.print("�ּҴ� ?");
		// white space (����, ' ' '\t') �ձ����� ��Ʈ���� ������
		String add = scanner.nextLine(); // nextLine(); ���鵵 �����ؼ� �Է¹��� �� �ִ�.
		
		System.out.print("���̴� ?");
		scanner.nextLine(); // \n ���ִ� ���� �����
		
		//int age = Integer.parseInt(scanner.nextLine()); �̷� ����� �ִ�. ���ڷ� ���ڸ� ���� ��츸 �ش�.
		int age = scanner.nextInt();
		
		System.out.println(name + " : " + age + "�쿡 �ּҴ� " + add);
		System.out.println("��");
		scanner.close();
	}

}
