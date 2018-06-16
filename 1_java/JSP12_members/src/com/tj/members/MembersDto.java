package com.tj.members;

import java.sql.Date;
import java.sql.Timestamp;
// DTO 에 반드시 들어가는 것 - 속성변수, setter getter, 매개변수 없는 생성자, toString()
public class MembersDto {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private Timestamp birth; // 타임 스탬프
	private Timestamp rDate; // 타임 스탬프
	private String address;
	
	public MembersDto() {}

	public MembersDto(String id, String pw, String name, String email, Timestamp birth, Timestamp rdate, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.rDate = rdate;
		this.address = address;
	}

	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", birth=" + birth
				+ ", rdate=" + rDate + ", address=" + address + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getBirth() {
		return birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	public Timestamp getrDate() {
		return rDate;
	}

	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
