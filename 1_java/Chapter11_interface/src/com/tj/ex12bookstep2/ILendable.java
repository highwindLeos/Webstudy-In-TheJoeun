package com.tj.ex12bookstep2;
// 도서 대출 클래스의 작업명세서 역활
public interface ILendable {
	// 대출중이면 책의 상태를 1 대출 가능하면 상태를 0
	byte STATE_BORROWED = 1;
	byte STATE_NOMAL = 0;
	
	void checkOut(String borrower, String checkOutDate); // 대출 메소드
	
	void checkIn(); // 반납 메소드
	
	void printState(); // 상태 조회 (대출중 대출 가능) 을 출력
	
}
