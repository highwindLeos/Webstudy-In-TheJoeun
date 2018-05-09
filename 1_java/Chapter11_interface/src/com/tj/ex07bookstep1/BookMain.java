package com.tj.ex07bookstep1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		BookLib[] books = { 
							new BookLib("A001", "이것이 자바다", "신용권"), 
							new BookLib("A002", "Web programing", "천인국"),
							new BookLib("A003", "JSP", "최범균"), 
							new BookLib("A004", "SPRING", "이스프링"),
							new BookLib("A005", "Oracle Database", "빅디비") 
							};
		// 1 대출 0 반납
		// if (1을 누르면) 책번호? 빌린사람? 빌린날? = 대출처리
		// if (0을 누르면) 책번호? => 해당책을 반납처리한다.
		// if (1도 0도 아닌 값을 누르면) 프로그램 종료.
		Scanner sc = new Scanner(System.in);
		int fn; // 기능 번호 변수
		int idx; // 찾는 책의 배열 index 번호
		String requestNo, borrower, checkOutDate;

		while (true) {
			System.out.print("하실일을 선택하세요. (1 대출 0 반납, 그외 수 : 종료)");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // 1-책번호 2-책을 찾고 3-책 idx 가져온다, 빌린사람, 빌린날 => 대출처리.
				System.out.println("대출 할 책의 번호를 입력하세요.");
				requestNo = sc.next();
				for (idx = 0; idx < books.length; idx++) { // 인덱스에서 책번호로 찾는다.
					if (books[idx].getRequestNo().equals(requestNo)) { // 입력한 값과 같은 값이있으면 참.
						break;// 대출하려 하는것.
					}
				}
				// 대출할 책의 index 를 idx 가 갖고 있는 상태. 책을 못찾으면 idx = 배열길이 값.
				if (idx == books.length) {
					System.out.println("유효하지 않는 책번호입니다.");
				} else {
					// this[idx] 를 대출하려는 것.
					System.out.println("대출할 사람 성함을 입력하세요?");
					borrower = sc.next();
					System.out.println("대출일은 (0000-00-00) ?");
					checkOutDate = sc.next();
					books[idx].checkOut(borrower, checkOutDate); // 대출 기능
				}
				break;
			case 0: // 1-책번호? 2-책의 인덱스를 가져온다. => 반납처리
				System.out.println("반납한 책 번호를 입력하세요.");
				requestNo = sc.next();
				for (idx = 0; idx < books.length; idx++) { // 인덱스에서 책번호로 찾는다.
					if (books[idx].getRequestNo().equals(requestNo)) { // 입력한 값과 같은 값이있으면 참.
						break;// 반납하려 하는것.
					}
				}

				if (idx == books.length) {
					System.out.println("유효하지 않는 책번호입니다.");
				} else {
					books[idx].checkIn(); // 반납 기능
				}
				break;
			default: break; 
			}

			if (fn != 1 && fn != 0) { // 기능번호 이외의 수로 입력되었을 때.
				break;
			}
		}

		System.out.println("안녕히 가세요. 현제 상황입니다.");
		for (BookLib bTemp : books) {
			bTemp.printState();
		}

		sc.close();

		/*
		 * book.printState(); book.checkOut("이레오", "2018-04-04");
		 * System.out.println("---------------------------------------");
		 * book.printState(); book.checkIn();
		 * System.out.println("---------------------------------------");
		 * book.printState();
		 */
		
	}

}