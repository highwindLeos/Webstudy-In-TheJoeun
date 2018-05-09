package com.tj.ex12bookstep2;

// data : 책번호, 책이름, 저자, 빌린이, 빌린날, 책상태
public class BookLib extends Bookinfo implements ILendable {

	private String borrower; // 빌린이
	private String checkOutDate;// 대출일
	private byte state; // 상태 (대출증 STATE_BORROWED , 대출가능 STATE_NOMAL)

	// new BookLib("840-a1","이것이 자바다","신용권");
	public BookLib() {
	}

	public BookLib(String requestNo, String bookTitle, String writer) {
		super(requestNo, bookTitle, writer);
		state = STATE_NOMAL;
		// borrower = null; checkOutDate = null; state = STATE_NOMAL;
	} // 초기화 생성자

	@Override
	public void checkOut(String borrower, String checkOutDate) { // 대출
		if (state != STATE_NOMAL) { // state == STATE_BORROWED 대출 가능이 아니라면
			System.out.println("대출 불가능 합니다.");
			return;
		}

		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출되었다는 상태로 변경.
		System.out.println("\"" + super.getBookTitle() + super.getWriter() +"\" 이(가) 대출 되었습니다.");
		System.out.println("[대출한 사람]" + borrower + "이(가) 대출.");
		System.out.println("[대출일]" + checkOutDate + "에 대출하였습니다.");
	}

	@Override
	public void checkIn() { // 반납
		if (state == STATE_BORROWED) { // 대출중인지 확인 true
			System.out.println("\"" + super.getBookTitle() + "\" 이(가) 반납 되었습니다."); // "이것이 자바다" 가 반납되었습니다.
			System.out.println("[반납한 사람]" + borrower + "이(가) 반납.");

			state = STATE_NOMAL;
			borrower = null;
			checkOutDate = null;
		} else {
			System.out.println("반납 할 책이 아닙니다. 관리자 확인 요망");
		}
	}
	
	@Override
	public void printState() { // "이것이 자바다" 는(은) 대출 가능 입니다. 출력
		if (state == STATE_NOMAL) {
			System.out.println("\"" + super.getBookTitle() + "\" 이(가) 대출 가능합니다.");
		} else if (state == STATE_BORROWED) {
			System.out.println("\"" + super.getBookTitle() + "\" 이(가) 대출중입니다.");
		} else {
			System.out.println("관리자의 확인을 요망합니다.");
		}
	}

	// getter setter

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
