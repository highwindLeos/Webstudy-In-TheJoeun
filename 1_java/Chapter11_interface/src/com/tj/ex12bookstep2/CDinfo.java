package com.tj.ex12bookstep2;

public class CDinfo {
	private String cdNo; // CD ��ȣ
	private String cdTitle; // CD �̸�
	private String bookNo; // å ��ȣ

	// ������
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