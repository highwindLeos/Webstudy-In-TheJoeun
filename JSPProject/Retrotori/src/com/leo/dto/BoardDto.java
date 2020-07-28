package com.leo.dto;

import java.sql.Date;

public class BoardDto {
	
	private int bNum;
	private String mId;
	private String bTitle;
	private String bContent;
	private int bCnt;
	private String bFile1;
	private int bRef;
	private int bStep;
	private int bLevel;
	private int bLike;
	private String bIp;
	private Date bRdate;
	private String mName;
	private String mPhoto;
	
	public BoardDto() {	}

	public int getbNum() {
		return bNum;
	}

	public BoardDto(int bNum, String mId, String bTitle, String bContent, int bCnt, String bFile1, int bRef, int bStep,
			int bLevel, int bLike, String bIp, Date bRdate, String mName, String mPhoto) {
		this.bNum = bNum;
		this.mId = mId;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bCnt = bCnt;
		this.bFile1 = bFile1;
		this.bRef = bRef;
		this.bStep = bStep;
		this.bLevel = bLevel;
		this.bLike = bLike;
		this.bIp = bIp;
		this.bRdate = bRdate;
		this.mName = mName;
		this.mPhoto = mPhoto;
	}
	
	@Override
	public String toString() {
		return "게시판 정보 [bNum=" + bNum + ", mId=" + mId + ", bTitle=" + bTitle + ", bContent=" + bContent + ", bCnt="
				+ bCnt + ", bFile1=" + bFile1 + ", bRef=" + bRef + ", bStep=" + bStep + ", bLevel=" + bLevel
				+ ", bLike=" + bLike + ", bIp=" + bIp + ", bRdate=" + bRdate + ", mName=" + mName + ", mPhoto=" + mPhoto
				+ "]";
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public int getbCnt() {
		return bCnt;
	}

	public void setbCnt(int bCnt) {
		this.bCnt = bCnt;
	}

	public String getbFile1() {
		return bFile1;
	}

	public void setbFile1(String bFile1) {
		this.bFile1 = bFile1;
	}

	public int getbRef() {
		return bRef;
	}

	public void setbRef(int bRef) {
		this.bRef = bRef;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbLevel() {
		return bLevel;
	}

	public void setbLevel(int bLevel) {
		this.bLevel = bLevel;
	}

	public int getbLike() {
		return bLike;
	}

	public void setbLike(int bLike) {
		this.bLike = bLike;
	}

	public String getbIp() {
		return bIp;
	}

	public void setbIp(String bIp) {
		this.bIp = bIp;
	}

	public Date getbRdate() {
		return bRdate;
	}

	public void setbRdate(Date bRdate) {
		this.bRdate = bRdate;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmPhoto() {
		return mPhoto;
	}


	public void setmPhoto(String mPhoto) {
		this.mPhoto = mPhoto;
	}
	
	
}
