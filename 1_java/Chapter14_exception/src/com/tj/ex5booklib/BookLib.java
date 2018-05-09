package com.tj.ex5booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookTitle; // å�̸�
	private String borrower; // ������
	private Date checkOutDate; // ������
	private byte state; // ���� ����

	public BookLib(String bookTitle) {
		this.bookTitle = bookTitle;
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL;
	} // ������ �ʱ�ȭ :

	@Override
	public void checkOut(String borrower) throws Exception {

		if (state == STATE_BORROWED) { // �����߻��� ��� ��.
			throw new Exception(bookTitle + "��(��) ���� ���� �Ұ����մϴ�. (������)");
		}

		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED; // "java" ������ ���� �Ǿ����ϴ�.

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E) hh�� mm��");

		System.out.println("\"" + bookTitle + "\"������ ����Ǿ����ϴ�.");
		System.out.println("[������] " + borrower);
		System.out.println("[������] " + sdf.format(checkOutDate));

	}

	@Override
	public void checkIn(Scanner sc) throws Exception {

		if (state == STATE_NOMAL) {
			throw new Exception(bookTitle + "������ �������� �ƴմϴ�.(���ܸ޼���)");
		}

		Date now = new Date(); // ����
		// now.getTime() : 1970 ����� ���ݱ��� �� �и�����
		// checkOutDate.getTime() : 1970 ��δ� ������ ��¥������ �и�����
		// diff : ���ݺ��� ������� ������ �и�����

		long diff = now.getTime() - checkOutDate.getTime();
		
		
		long borrowedDay = diff / (1000 * 60 * 60 * 24); // ���� �ϼ��� ȯ��.
		System.out.println(borrowedDay);
		if (borrowedDay > 14) { // �������� 7���� �Ѿ��ٸ� ��.
			int money = (int) (borrowedDay - 14) * 100;
			System.out.println("��ü��� : " + money + "��(100��/day)");
			System.out.print("��ü�Ḧ �����̳���?(Y/N)?");

			if (sc.next().equalsIgnoreCase("n")) { // n N �� �Է�������
				System.out.println("��ü�� �����;� �ݳ������մϴ�.");
				return;
			} // ��ü�� ���� ����
		} // ��ü�� �Ǿ��� ��� if��
		
		//�ݳ��� ���� ������ ����. 
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL; // "java" ������ �ݳ� �Ǿ����ϴ�.

		System.out.println("\"" + bookTitle + "\"������ �ݳ��Ǿ����ϴ�.");
	}

	@Override
	public String toString() {
		String resulte;
		
		resulte = "[å�̸�] : " + bookTitle;
		resulte += " \t[���� ���� ����] : " + (state == STATE_NOMAL ? "���Ⱑ��" : "������"); 
		if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E) hh�� mm��");
			resulte += "\t[������] : " + sdf.format(checkOutDate);
		}
		
		return resulte;
	}
	
	// setter

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBorrower() {
		return borrower;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public byte getState() {
		return state;
	}
	
}
