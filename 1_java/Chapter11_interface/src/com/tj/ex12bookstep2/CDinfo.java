package com.tj.ex12bookstep2;

public class CDinfo {
	private String cdNo; // CD 번호
	private String cdTitle; // CD 이름
	private String bookNo; // 책 번호

	// 생성자
	public CDinfo() {
	}

	public CDinfo(String cdNo, String cdTitle, String bookNo) {
		this.cdNo = cdNo;
		this.cdTitle = cdTitle;
		this.bookNo = bookNo;
	}
	
	// setter setter

	public String getCdNo() {
		return cdNo;
	}

	public void setCdNo(String cdNo) {
		this.cdNo = cdNo;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

}