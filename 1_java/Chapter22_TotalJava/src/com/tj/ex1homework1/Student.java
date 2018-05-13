package com.tj.ex1homework1;

public class Student {
	private String sno;
	private String sname;
	private int mno;
	private int score;
	private int expel;
	private String mname;
	
	public Student() {}
	
	public Student(String sno, String sname, int mno, int score, int expel, String mname) {
		this.sno = sno;
		this.sname = sname;
		this.mno = mno;
		this.score = score;
		this.expel = expel;
		this.mname = mname;
	}
	
	@Override
	public String toString() {
		String result = "[학번] : " + sno + " [이름] : " + sname + " [학과명] : " + mname +  " [점수] : " + score + "\n";
		return result;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setExpel(int expel) {
		this.expel = expel;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
