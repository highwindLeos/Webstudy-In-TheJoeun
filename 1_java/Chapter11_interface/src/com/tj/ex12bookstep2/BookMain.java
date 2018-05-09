package com.tj.ex12bookstep2;

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
		
		CDLib[] cds = { 
						new CDLib("01", "�̰��� �ڹٴ�", "A001"), 
						new CDLib("02", "Web programing", "A002"),
						new CDLib("03", "JSP", "A003"), 
						};
		// 1 ���� 0 �ݳ�
		// if (1�� ������) å��ȣ? �������? ������? = ����ó��
		// if (0�� ������) å��ȣ? => �ش�å�� �ݳ�ó���Ѵ�.
		// if (1�� 0�� �ƴ� ���� ������) ���α׷� ����.
		Scanner sc = new Scanner(System.in);
		int fn; // ��� ��ȣ ����
		int idx; // ã�� å�� �迭 index ��ȣ
		String requestNo, borrower="", checkOutDate="", OX;

		while (true) {
			System.out.print("�Ͻ����� �����ϼ���. (1 å���� 2 å�ݳ� 3 CD���� 4 CD�ݳ� 0 ����)");
			fn = sc.nextInt();
			
			if (fn == 0) break; // 0 �ϰ�� while ��������

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
				
				do {
					System.out.print("���� CD�� �����Ͻðڽ��ϱ�?(O or X)");
					OX = sc.next();
				} while(!OX.equalsIgnoreCase("o") && !OX.equalsIgnoreCase("x")) ; //do while
				
				if(OX.equalsIgnoreCase("X")) {
					System.out.println("CD�� �������� �ʰٽ��ϴ�");
					break;
				} else {
					String tempBookNo = books[idx].getBookTitle();
					int csIdx;
					for(csIdx=0 ; csIdx < cds.length ; csIdx++) {
						if(cds[csIdx].getBookNo().equals(tempBookNo)) {
							break;
						}
					}
					cds[csIdx].checkOut(borrower, checkOutDate);
				}
				
				break;
				
			case 2: // 1-å��ȣ? 2-å�� �ε����� �����´�. => �ݳ�ó��
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
				
			case 3: // 1-CD��ȣ 2-CD�� ã�� 3- CD idx �����´�, �������, ������ => ����ó��.
				System.out.println("���� �� CD�� å�̸��� �Է��ϼ���.");
				requestNo = sc.next();
				for (idx = 0; idx < books.length; idx++) { // �ε������� å��ȣ�� ã�´�.
					if (cds[idx].getCdTitle().equals(requestNo)) { // �Է��� ���� ���� ���������� ��.
						break;// �����Ϸ� �ϴ°�.
					}
				}
				// ������ å�� index �� idx �� ���� �ִ� ����. å�� ��ã���� idx = �迭���� ��.
				if (idx == cds.length) {
					System.out.println("��ȿ���� �ʴ� CD �Դϴ�.");
				} else {
					// this[idx] �� �����Ϸ��� ��.
					System.out.println("������ ��� ������ �Է��ϼ���?");
					borrower = sc.next();
					System.out.println("�������� (0000-00-00) ?");
					checkOutDate = sc.next();
					cds[idx].checkOut(borrower, checkOutDate); // ���� ���
				}
				break;
				
			case 4:// 1-CD��ȣ? 2-CD�� �ε����� �����´�. => �ݳ�ó��
				System.out.println("�ݳ��� CD �̸��� �Է��ϼ���.");
				requestNo = sc.next();
				for (idx = 0; idx < books.length; idx++) { // �ε������� å��ȣ�� ã�´�.
					if (cds[idx].getCdTitle().equals(requestNo)) { // �Է��� ���� ���� ���������� ��.
						break;// �ݳ��Ϸ� �ϴ°�.
					}
				}

				if (idx == cds.length) {
					System.out.println("��ȿ���� �ʴ� å��ȣ�Դϴ�.");
				} else {
					cds[idx].checkIn(); // �ݳ� ���
				}
				break;
				
			default: break; 
			}

			if (fn != 1 && fn != 2 && fn != 3 && fn != 4 ) { // ��ɹ�ȣ �̿��� ���� �ԷµǾ��� ��.
				break;
			}
		}

		System.out.println("�ȳ��� ������. ���� ���� ��Ȳ �Դϴ�.");
		System.out.println();
		for (BookLib bTemp : books) {
			bTemp.printState();
		}
		System.out.println("===================================");
		for (CDLib cTemp : cds) {
			cTemp.printState();
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