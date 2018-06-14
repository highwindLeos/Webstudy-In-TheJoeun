package com.tj.dto;

public class FriendDto {
	private int no;
	private String fname;
	private String tel;
	
	public FriendDto() {}

	public FriendDto(int no, String fname, String tel) {
		this.no = no;
		this.fname = fname;
		this.tel = tel;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
