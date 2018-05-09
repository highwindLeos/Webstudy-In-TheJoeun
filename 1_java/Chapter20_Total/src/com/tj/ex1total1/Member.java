package com.tj.ex1total1;

public class Member {
	private String phoneNum;
	private String name;
	private int point;
	
	public Member() {}
	
	public Member(String phoneNum, String name, int point) {
		this.phoneNum = phoneNum;
		this.name = name;
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "[phoneNum] " + phoneNum + " [name] " + name + " [point] " + point;
	}

	// setter getter
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
