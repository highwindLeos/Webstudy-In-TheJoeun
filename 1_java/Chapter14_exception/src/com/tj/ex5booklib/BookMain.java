package com.tj.ex5booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookMain {
	
	private static BookLib[] books = { 
										new BookLib("java"), 
										new BookLib("javascript"), 
										new BookLib("database"), 
										new BookLib("jsp"), 
										new BookLib("spring") 
									};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			books[0].checkOut("Leos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try { // ���ȴµ� �ٽ� �������ϹǷ� ���� catch �� ����
			books[0].checkOut("Leos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			books[1].checkOut("Leos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(books[0]);
		books[0].setCheckOutDate(new Date(118,2,3)); // 2018�� 3�� 3�� : ���� ������ ���̽����� �����´�.
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E) hh�� mm��");
			System.out.println("[���� �ݳ���] : " + sdf.format(books[0].getCheckOutDate()));
			books[0].checkIn(sc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			books[0].checkIn(sc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("���� ���� �����Դϴ�. �����մϴ�.");
		
		for (BookLib tb : books) {
			System.out.println(tb);
		}
		
	}// main()

}
