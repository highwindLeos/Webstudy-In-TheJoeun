package com.tj.ex09scanner;

import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���̴� ?");
		// white space ('\n', ' ' '\t') �ձ����� ������ ������
		int age = scanner.nextInt();
		
		System.out.print("�̸��� ?");
		// white space (����, ' ' '\t') �ձ����� ��Ʈ���� ������
		String name = scanner.next();
		
		System.out.print("�ּҴ� ?");
		// \n �� ���ۿ� ���� �Է��̶�� �����͸� �Է��Ҽ� ����.
		scanner.nextLine(); // ���۸� ����� �뵵
		String add = scanner.nextLine(); // nextLine(); ���鵵 �����ؼ� �Է¹��� �� �ִ�.
		System.out.println(name + " : " + age + "�쿡 �ּҴ� " + add);
		System.out.println("��");
		scanner.close();
	}

}
