package com.tj.ex2total;

public class Student {
	private int hakbun;
	private String name;
	private String major;
	private int point;
	
	public Student() {	}
	
	public Student(int hakbun, String name, String major, int point) {
		this.hakbun = hakbun;
		this.name = name;
		this.major = major;
		this.point = point;
	}

	@Override
	public String toString() {
		return "[학번]" + hakbun + "[이름]" + name + "[학과]" + major + "[점수]" + point;
	}

	// getter
	public int getHakbun() {
		return hakbun;
	}

	public String getName() {
		return name;
	}
	
	public String getMajor() {
		return major;
	}

	public int getPoint() {
		return point;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
