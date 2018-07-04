package com.tj.mvcmember.dto;

import java.sql.Timestamp;

public class BoardDto {
	
	private int bId;
	private String mId;
	private String bName;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private int bHit;
	private int bGroup;
	private int bStep;
	private int bIndent;
	private String bIp;
	private String mName;
	private String mEmail;
	
	public BoardDto() {}

	public BoardDto(int bId, String mId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit,
			int bGroup, int bStep, int bIndent, String bIp, String mName, String mEmail) {
		this.bId = bId;
		this.mId = mId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
		this.bIp = bIp;
		this.mName = mName;
		this.mEmail = mEmail;
	}


	@Override
	public String toString() {
		return "보드 정보 [bId=" + bId + ", mId=" + mId + ", bName=" + bName + ", bTitle=" + bTitle + ", bContent="
				+ bContent + ", bDate=" + bDate + ", bHit=" + bHit + ", bGroup=" + bGroup + ", bStep=" + bStep
				+ ", bIndent=" + bIndent + ", bIp=" + bIp + ", mName=" + mName + ", mEmail=" + mEmail + "]";
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
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

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGroup() {
		return bGroup;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}

	public String getbIp() {
		return bIp;
	}

	public void setbIp(String bIp) {
		this.bIp = bIp;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

}
