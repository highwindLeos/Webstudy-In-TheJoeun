package com.tj.ex12bookstep2;

public class Bookinfo {
	private String requestNo; // û�� ��ȣ
	private String bookTitle; // å �̸�
	private String writer; // ����

	// ������
	public Bookinfo() {
	}

	public Bookinfo(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// setter setter
	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
