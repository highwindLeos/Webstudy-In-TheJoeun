package com.leo.dto;

import java.sql.Date;

public class NoticeDto {
	private int nNum;
	private String nTitle;
	private String nContent;
	private String nAuthor;
	private Date nRdate;
	
	public NoticeDto() {}

	public NoticeDto(int nNum, String nTitle, String nContent, String nAuthor, Date nRdate) {
		this.nNum = nNum;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nAuthor = nAuthor;
		this.nRdate = nRdate;
	}

	@Override
	public String toString() {
		return "공지사항 정보 [nNum=" + nNum + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nAuthor=" + nAuthor
				+ ", nRdate=" + nRdate + "]";
	}

	public int getnNum() {
		return nNum;
	}

	public void setnNum(int nNum) {
		this.nNum = nNum;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnAuthor() {
		return nAuthor;
	}

	public void setnAuthor(String nAuthor) {
		this.nAuthor = nAuthor;
	}

	public Date getnRdate() {
		return nRdate;
	}

	public void setnRdate(Date nRdate) {
		this.nRdate = nRdate;
	}

}
