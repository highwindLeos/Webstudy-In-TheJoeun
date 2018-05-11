package com.tj.ex2homework2;

public class Customer {

	private int cno;
	private String ctel;
	private String cname;
	private int point;
	private int buy;
	private int gno;
	private String grade;
	private int levelup;
	
	public Customer(int cno, String ctel, String cname, int point, int buy, int gno, String grade, int levelup) {
		this.cno = cno;
		this.ctel = ctel;
		this.cname = cname;
		this.point = point;
		this.buy = buy;
		this.gno = gno;
		this.grade = grade;
		this.levelup = levelup;
	}
	
	public Customer(int cno, String ctel, String cname, int point, int buy, String grade, int levelup) {
		this.cno = cno;
		this.ctel = ctel;
		this.cname = cname;
		this.point = point;
		this.buy = buy;
		this.grade = grade;
		this.levelup = levelup;
	}

	@Override
	public String toString() {
		String resulte = "[고객ID] : " + cno;
		resulte += "  [고객연락처] : " + ctel;
		resulte += "  [고객명] : " + cname;
		resulte += "  [포인트] : " + point;
		resulte += "  [구매총액] : " + buy;
		resulte += "  [고객등급] : " + grade; 
		resulte += "  [다음레벨업 구매액]" + levelup + "\n";
		
		return resulte;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setBuy(int buy) {
		this.buy = buy;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
