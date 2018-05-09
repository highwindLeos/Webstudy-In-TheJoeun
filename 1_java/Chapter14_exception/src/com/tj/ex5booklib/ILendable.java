package com.tj.ex5booklib;

import java.util.Scanner;

public interface ILendable {
	byte STATE_BORROWED = 1; // 대출상태
	byte STATE_NOMAL = 0; // 대출가능상태 
	
	public void checkOut(String borrower) throws Exception; // 대출
	public void checkIn(Scanner sc) throws Exception; // 반납
}
