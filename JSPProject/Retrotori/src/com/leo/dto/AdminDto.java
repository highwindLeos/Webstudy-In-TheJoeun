package com.leo.dto;

public class AdminDto {
	private int aNum;
	private String aId;
	private String aPw;
	private String aName;
	
	public AdminDto() {	}

	public AdminDto(int aNum, String aId, String aPw, String aName) {
		this.aNum = aNum;
		this.aId = aId;
		this.aPw = aPw;
		this.aName = aName;
	}
	
	@Override
	public String toString() {
		return "관리자 정보 [aNum=" + aNum + ", aId=" + aId + ", aPw=" + aPw + ", aName=" + aName + "]";
	}

	public int getaNum() {
		return aNum;
	}

	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	
	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaPw() {
		return aPw;
	}

	public void setaPw(String aPw) {
		this.aPw = aPw;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

}
