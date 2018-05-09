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
		
		try { // 빌렸는데 다시 빌리려하므로 예외 catch 로 진행
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
		books[0].setCheckOutDate(new Date(118,2,3)); // 2018년 3월 3일 : 보통 데이터 베이스에서 가져온다.
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) hh시 mm분");
			System.out.println("[대출 반납일] : " + sdf.format(books[0].getCheckOutDate()));
			books[0].checkIn(sc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			books[0].checkIn(sc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("현제 대출 상태입니다. 종료합니다.");
		
		for (BookLib tb : books) {
			System.out.println(tb);
		}
		
	}// main()

}
