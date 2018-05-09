package com.tj.ex07bookstep1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		BookLib[] books = { 
							new BookLib("A001", "�̰��� �ڹٴ�", "�ſ��"), 
							new BookLib("A002", "Web programing", "õ�α�"),
							new BookLib("A003", "JSP", "�ֹ���"), 
							new BookLib("A004", "SPRING", "�̽�����"),
							new BookLib("A005", "Oracle Database", "����") 
							};
		// 1 ���� 0 �ݳ�
		// if (1�� ������) å��ȣ? �������? ������? = ����ó��
		// if (0�� ������) å��ȣ? => �ش�å�� �ݳ�ó���Ѵ�.
		// if (1�� 0�� �ƴ� ���� ������) ���α׷� ����.
		Scanner sc = new Scanner(System.in);
		int fn; // ��� ��ȣ ����
		int idx; // ã�� å�� �迭 index ��ȣ
		String requestNo, borrower, checkOutDate;

		while (true) {
			System.out.print("�Ͻ����� �����ϼ���. (1 ���� 0 �ݳ�, �׿� �� : ����)");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // 1-å��ȣ 2-å�� ã�� 3-å idx �����´�, �������, ������ => ����ó��.
				System.out.println("���� �� å�� ��ȣ�� �Է��ϼ���.");
				requestNo = sc.next();
				for (idx = 0; idx < books.length; idx++) { // �ε������� å��ȣ�� ã�´�.
					if (books[idx].getRequestNo().equals(requestNo)) { // �Է��� ���� ���� ���������� ��.
						break;// �����Ϸ� �ϴ°�.
					}
				}
				// ������ å�� index �� idx �� ���� �ִ� ����. å�� ��ã���� idx = �迭���� ��.
				if (idx == books.length) {
					System.out.println("��ȿ���� �ʴ� å��ȣ�Դϴ�.");
				} else {
					// this[idx] �� �����Ϸ��� ��.
					System.out.println("������ ��� ������ �Է��ϼ���?");
					borrower = sc.next();
					System.out.println("�������� (0000-00-00) ?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate); // ���� ���
				}
				break;
			case 0: // 1-å��ȣ? 2-å�� �ε����� �����´�. => �ݳ�ó��
				System.out.println("�ݳ��� å ��ȣ�� �Է��ϼ���.");
				requestNo = sc.next();
				for (idx = 0; idx < books.length; idx++) { // �ε������� å��ȣ�� ã�´�.
					if (books[idx].getRequestNo().equals(requestNo)) { // �Է��� ���� ���� ���������� ��.
						break;// �ݳ��Ϸ� �ϴ°�.
					}
				}

				if (idx == books.length) {
					System.out.println("��ȿ���� �ʴ� å��ȣ�Դϴ�.");
				} else {
					books[idx].checkIn(); // �ݳ� ���
				}
				break;
			default: break; 
			}

			if (fn != 1 && fn != 0) { // ��ɹ�ȣ �̿��� ���� �ԷµǾ��� ��.
				break;
			}
		}

		System.out.println("�ȳ��� ������. ���� ��Ȳ�Դϴ�.");
		for (BookLib bTemp : books) {
			bTemp.printState();
		}

		sc.close();

		/*
		 * book.printState(); book.checkOut("�̷���", "2018-04-04");
		 * System.out.println("---------------------------------------");
		 * book.printState(); book.checkIn();
		 * System.out.println("---------------------------------------");
		 * book.printState();
		 */
		
	}

}