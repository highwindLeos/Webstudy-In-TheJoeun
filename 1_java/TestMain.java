package com.tj.ex07bookstep3;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		BookLib[] bs = { new BookLib("a001", "java", "신용권"), new BookLib("a002", "web", "홍길동"),
				new BookLib("a003", "jsp", "신길동"), new BookLib("a004", "spring", "이스프"),
				new BookLib("a005", "db", "박디비") };
		CDLib[] cs = { new CDLib("a01", "cjava", "a001"), new CDLib("a02", "cweb", "a002"),
				new CDLib("a03", "cjsp", "a003"), new CDLib("a04", "cspring", "a004"),
				new CDLib("a05", "cdb", "a005") };

		Scanner sc = new Scanner(System.in);
		int fn; // 기능번호(1:대출 0:반납)
		String bookNo, borrower="", checkOutDate="", cdNo, cdTitle,cdborrower;
		int idx; // 찾는 책의 배열 index번호
		String OX;
		while (true) {
			System.out.print("원하는 기능은? (1:책대출,2:CD대출 3:책반납 ,4:CD반납,0:종료)");
			fn = sc.nextInt();
			switch (fn) {
			case 1: // 대출처리하고 break; //책번호? 책을찾고 idx가져온다. 빌린이이름? 빌린날? => 대출처리
				System.out.println("대출하고자하는 책번호는? ");
				bookNo = sc.next();
				for (idx = 0; idx < bs.length; idx++) {
					if (bs[idx].getBookNo().equals(bookNo)) {
						break; // for문을 빠져나감
					}
				}
				// ★ idx 대출할 책의 index를 idx가 갖고 있는 상태. 책을 못찾으면 idx=5
				if (idx == bs.length) {
					System.out.println("유효하지 않은 책번호 입니다");
				}else {
					// bx[idx] 를 대출하려함.
					System.out.print("대출인은?");
					borrower = sc.next();
					System.out.print("대출일은?");
					checkOutDate = sc.next();
					bs[idx].checkOut(borrower, checkOutDate);// 대출함
				}
				
				do {
					System.out.print("동봉 CD도 대출하시겠습니까?(O or X)");
					OX = sc.next();
					
					/*if(OX.equals("O")) {
							break;
					}else if(OX.equals("X")){
						break;
					} else {
						System.out.println("OX만 입력해주십시오");
					}*/
				}while(!OX.equalsIgnoreCase("o") && !OX.equalsIgnoreCase("x")) ; //do while
				
				if(OX.equalsIgnoreCase("X")) {
					System.out.println("CD는 대출하지 않겟습니다");
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
				System.out.println("대출하고자 하는 CD번호는? ");
				cdNo = sc.next();
				for (idx = 0; idx < cs.length; idx++) {
					if (cs[idx].getCdNo().equals(cdNo)) {
						break;
					}
				}
				if (idx == cs.length) {
					System.out.println("유효하지 않은 CD번호 입니다");
				} else {
					System.out.println("대출인은?");
					borrower = sc.next();
					System.out.println("대출일은?");
					checkOutDate = sc.next();
					cs[idx].checkOut(borrower, checkOutDate);
				}
				break;

			case 3: // 반납처리하고 break; //1 책번호? 2책의 idx를 가져온다 => 해당책을 반납처리한다
				System.out.print("반납하고자 하는 책번호는 ?");
				bookNo = sc.next();
				for (idx = 0; idx < bs.length; idx++) {
					if (bs[idx].getBookNo().equals(bookNo)) {
						break; // 같은면 for문 빠져나가
					} // if
				} // for
				if (idx == bs.length) {
					System.out.println("없는 책입니다");
				} else {
					bs[idx].checkIn();
				}
				break;

			case 4:
				System.out.print("반납하고자 하는 CD번호는 ?");
				cdNo = sc.next();
				for (idx = 0; idx < cs.length; idx++) {
					if (cs[idx].getCdNo().equals(cdNo)) {
						break; // 같은면 for문 빠져나가
					} // if
				} // for
				if (idx == cs.length) {
					System.out.println("없는 CD입니다");
				} else {
					cs[idx].checkIn();
				}
				break;

			default:
				break;
			}
			
			if (fn != 1 && fn != 2 && fn != 3 && fn != 4) {
				break; // 그외 수는 반복문을 빠져나감
			}
		} // while
			// 1:대출 0:반납
			// if(1을 누르면) 책번호? 빌린이이름? 빌린날? => 대출처리
			// if(0을 누르면) 책번호? => 해당책을 반납처리한다
			// if(1도 아니고 0도 아닌 값을 누르면) 프로그램 종료
		System.out.println("종료");
		for (BookLib b : bs) {
			b.printState();
		}
		System.out.println("------- CD List --------");
		for (CDLib c : cs) {
			c.printState();
		}
	}// main
}// class
