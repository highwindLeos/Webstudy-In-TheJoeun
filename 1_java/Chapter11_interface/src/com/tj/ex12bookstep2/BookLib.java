package com.tj.ex12bookstep2;

// data : å��ȣ, å�̸�, ����, ������, ������, å����
public class BookLib extends Bookinfo implements ILendable {

	private String borrower; // ������
	private String checkOutDate;// ������
	private byte state; // ���� (������ STATE_BORROWED , ���Ⱑ�� STATE_NOMAL)

	// new BookLib("840-a1","�̰��� �ڹٴ�","�ſ��");
	public BookLib() {
	}

	public BookLib(String requestNo, String bookTitle, String writer) {
		super(requestNo, bookTitle, writer);
		state = STATE_NOMAL;
		// borrower = null; checkOutDate = null; state = STATE_NOMAL;
	} // �ʱ�ȭ ������

	@Override
	public void checkOut(String borrower, String checkOutDate) { // ����
		if (state != STATE_NOMAL) { // state == STATE_BORROWED ���� ������ �ƴ϶��
			System.out.println("���� �Ұ��� �մϴ�.");
			return;
		}

		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // ����Ǿ��ٴ� ���·� ����.
		System.out.println("\"" + super.getBookTitle() + super.getWriter() +"\" ��(��) ���� �Ǿ����ϴ�.");
		System.out.println("[������ ���]" + borrower + "��(��) ����.");
		System.out.println("[������]" + checkOutDate + "�� �����Ͽ����ϴ�.");
	}

	@Override
	public void checkIn() { // �ݳ�
		if (state == STATE_BORROWED) { // ���������� Ȯ�� true
			System.out.println("\"" + super.getBookTitle() + "\" ��(��) �ݳ� �Ǿ����ϴ�."); // "�̰��� �ڹٴ�" �� �ݳ��Ǿ����ϴ�.
			System.out.println("[�ݳ��� ���]" + borrower + "��(��) �ݳ�.");

			state = STATE_NOMAL;
			borrower = null;
			checkOutDate = null;
		} else {
			System.out.println("�ݳ� �� å�� �ƴմϴ�. ������ Ȯ�� ���");
		}
	}
	
	@Override
	public void printState() { // "�̰��� �ڹٴ�" ��(��) ���� ���� �Դϴ�. ���
		if (state == STATE_NOMAL) {
			System.out.println("\"" + super.getBookTitle() + "\" ��(��) ���� �����մϴ�.");
		} else if (state == STATE_BORROWED) {
			System.out.println("\"" + super.getBookTitle() + "\" ��(��) �������Դϴ�.");
		} else {
			System.out.println("�������� Ȯ���� ����մϴ�.");
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
