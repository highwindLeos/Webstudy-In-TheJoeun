package com.leo.dto;

public class ComantDto {
	
	private int cNum;
	private String gId;
	private String mId;
	private String comant;
	
	public ComantDto() {}

	public ComantDto(int cNum, String gId, String mId, String comant) {
		this.cNum = cNum;
		this.gId = gId;
		this.mId = mId;
		this.comant = comant;
	}

	@Override
	public String toString() {
		return "코멘트 정보 [cNum=" + cNum + ", gId=" + gId + ", mId=" + mId + ", comant=" + comant + "]";
	}

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getComant() {
		return comant;
	}

	public void setComant(String comant) {
		this.comant = comant;
	}
	
}
