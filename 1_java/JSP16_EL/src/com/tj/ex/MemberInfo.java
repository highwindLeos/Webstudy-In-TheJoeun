package com.tj.ex;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class MemberInfo {
	private String name;
	private String id;
	private String pw;
	
	public MemberInfo() {}
	
	public MemberInfo(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "사용자 정보 [이름 =" + name + ", 아이디 =" + id + ", 패스워드 =" + pw + "]";
	}
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

}
