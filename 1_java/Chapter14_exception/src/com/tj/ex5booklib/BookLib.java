package com.tj.ex5booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String bookTitle; // 책이름
	private String borrower; // 대출자
	private Date checkOutDate; // 대출일
	private byte state; // 대출 상태

	public BookLib(String bookTitle) {
		this.bookTitle = bookTitle;
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL;
	} // 데이터 초기화 :

	@Override
	public void checkOut(String borrower) throws Exception {

		if (state == STATE_BORROWED) { // 대출중상태 라면 참.
			throw new Exception(bookTitle + "은(는) 현제 대출 불가능합니다. (대출중)");
		}

		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED; // "java" 도서가 대출 되었습니다.

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) hh시 mm분");

		System.out.println("\"" + bookTitle + "\"도서가 대출되었습니다.");
		System.out.println("[대출인] " + borrower);
		System.out.println("[대출일] " + sdf.format(checkOutDate));

	}

	@Override
	public void checkIn(Scanner sc) throws Exception {

		if (state == STATE_NOMAL) {
			throw new Exception(bookTitle + "도서가 대출중이 아닙니다.(예외메세지)");
		}

		Date now = new Date(); // 지금
		// now.getTime() : 1970 년부터 지금까지 의 밀리세컨
		// checkOutDate.getTime() : 1970 년부더 대출한 날짜까지의 밀리세컨
		// diff : 지금부터 대출시점 까지의 밀리세컨

		long diff = now.getTime() - checkOutDate.getTime();
		
		
		long borrowedDay = diff / (1000 * 60 * 60 * 24); // 대출 일수로 환산.
		System.out.println(borrowedDay);
		if (borrowedDay > 14) { // 대출일이 7일이 넘었다면 참.
			int money = (int) (borrowedDay - 14) * 100;
			System.out.println("연체료는 : " + money + "원(100원/day)");
			System.out.print("연체료를 받으셨나요?(Y/N)?");

			if (sc.next().equalsIgnoreCase("n")) { // n N 을 입력했을때
				System.out.println("연체료 가져와야 반납가능합니다.");
				return;
			} // 연체료 납부 여부
		} // 연체가 되었을 경우 if문
		
		//반납을 위해 데이터 가공. 
		this.borrower = null;
		checkOutDate = null;
		state = STATE_NOMAL; // "java" 도서가 반납 되었습니다.

		System.out.println("\"" + bookTitle + "\"도서가 반납되었습니다.");
	}

	@Override
	public String toString() {
		String resulte;
		
		resulte = "[책이름] : " + bookTitle;
		resulte += " \t[대출 가능 상태] : " + (state == STATE_NOMAL ? "대출가능" : "대출중"); 
		if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) hh시 mm분");
			resulte += "\t[대출일] : " + sdf.format(checkOutDate);
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
