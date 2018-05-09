package com.tj.ex07bookstep3;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] bs = { new BookLib("a001", "java", "�ſ��"), new BookLib("a002", "web", "ȫ�浿"),
				new BookLib("a003", "jsp", "�ű浿"), new BookLib("a004", "spring", "�̽���"),
				new BookLib("a005", "db", "�ڵ��") };
		CDLib[] cs = { new CDLib("a01", "cjava", "a001"), new CDLib("a02", "cweb", "a002"),
				new CDLib("a03", "cjsp", "a003"), new CDLib("a04", "cspring", "a004"),
				new CDLib("a05", "cdb", "a005") };

		Scanner sc = new Scanner(System.in);
		int fn; // ��ɹ�ȣ(1:���� 0:�ݳ�)
		String bookNo, borrower="", checkOutDate="", cdNo, cdTitle,cdborrower;
		int idx; // ã�� å�� �迭 index��ȣ
		String OX;
		while (true) {
			System.out.print("���ϴ� �����? (1:å����,2:CD���� 3:å�ݳ� ,4:CD�ݳ�,0:����)");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // ����ó���ϰ� break; //å��ȣ? å��ã�� idx�����´�. �������̸�? ������? => ����ó��
				System.out.println("�����ϰ����ϴ� å��ȣ��? ");
				bookNo = sc.next();
				for (idx = 0; idx < bs.length; idx++) {
					if (bs[idx].getBookNo().equals(bookNo)) {
						break; // for���� ��������
					}
				}
				// �� idx ������ å�� index�� idx�� ���� �ִ� ����. å�� ��ã���� idx=5
				if (idx == bs.length) {
					System.out.println("��ȿ���� ���� å��ȣ �Դϴ�");
				}else {
					// bx[idx] �� �����Ϸ���.
					System.out.print("��������?");
					borrower = sc.next();
					System.out.print("��������?");
					checkOutDate = sc.next();
					bs[idx].checkOut(borrower, checkOutDate);// ������
				}
				
				do {
					System.out.print("���� CD�� �����Ͻðڽ��ϱ�?(O or X)");
					OX = sc.next();
					
					/*if(OX.equals("O")) {
							break;
					}else if(OX.equals("X")){
						break;
					} else {
						System.out.println("OX�� �Է����ֽʽÿ�");
					}*/
				}while(!OX.equalsIgnoreCase("o") && !OX.equalsIgnoreCase("x")) ; //do while
				
				if(OX.equalsIgnoreCase("X")) {
					System.out.println("CD�� �������� �ʰٽ��ϴ�");
					break;
				}else {
					String tempBookNo = bs[idx].getBookNo();
					int csIdx;
					for(csIdx=0 ; csIdx<cs.length ; csIdx++) {
						if(cs[csIdx].getBookNo().equals(tempBookNo)) {
							break;
						}
					}
					cs[csIdx].checkOut(borrower, checkOutDate);
				}
				break;
			case 2:
				System.out.println("�����ϰ��� �ϴ� CD��ȣ��? ");
				cdNo = sc.next();
				for (idx = 0; idx < cs.length; idx++) {
					if (cs[idx].getCdNo().equals(cdNo)) {
						break;
					}
				}
				if (idx == cs.length) {
					System.out.println("��ȿ���� ���� CD��ȣ �Դϴ�");
				} else {
					System.out.println("��������?");
					borrower = sc.next();
					System.out.println("��������?");
					checkOutDate = sc.next();
					cs[idx].checkOut(borrower, checkOutDate);
				}
				break;

			case 3: // �ݳ�ó���ϰ� break; //1 å��ȣ? 2å�� idx�� �����´� => �ش�å�� �ݳ�ó���Ѵ�
				System.out.print("�ݳ��ϰ��� �ϴ� å��ȣ�� ?");
				bookNo = sc.next();
				for (idx = 0; idx < bs.length; idx++) {
					if (bs[idx].getBookNo().equals(bookNo)) {
						break; // ������ for�� ��������
					} // if
				} // for
				if (idx == bs.length) {
					System.out.println("���� å�Դϴ�");
				} else {
					bs[idx].checkIn();
				}
				break;

			case 4:
				System.out.print("�ݳ��ϰ��� �ϴ� CD��ȣ�� ?");
				cdNo = sc.next();
				for (idx = 0; idx < cs.length; idx++) {
					if (cs[idx].getCdNo().equals(cdNo)) {
						break; // ������ for�� ��������
					} // if
				} // for
				if (idx == cs.length) {
					System.out.println("���� CD�Դϴ�");
				} else {
					cs[idx].checkIn();
				}
				break;

			default:
				break;
			}
			
			if (fn != 1 && fn != 2 && fn != 3 && fn != 4) {
				break; // �׿� ���� �ݺ����� ��������
			}
		} // while
			// 1:���� 0:�ݳ�
			// if(1�� ������) å��ȣ? �������̸�? ������? => ����ó��
			// if(0�� ������) å��ȣ? => �ش�å�� �ݳ�ó���Ѵ�
			// if(1�� �ƴϰ� 0�� �ƴ� ���� ������) ���α׷� ����
		System.out.println("����");
		for (BookLib b : bs) {
			b.printState();
		}
		System.out.println("------- CD List --------");
		for (CDLib c : cs) {
			c.printState();
		}
	}// main
}// class
