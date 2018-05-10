package com.tj.ex2homework2;

public class Customer {

	private int cno;
	private String ctel;
	private String cname;
	private int point;
	private int buy;
	private int gno;
	private String grade;
	
	public Customer(int cno, String ctel, String cname, int point, int buy, int gno, String grade) {
		this.cno = cno;
		this.ctel = ctel;
		this.cname = cname;
		this.point = point;
		this.buy = buy;
		this.gno = gno;
		this.grade = grade;
	}
	
	public Customer(int cno, String ctel, String cname, int point, int buy, String grade) {
		this.cno = cno;
		this.ctel = ctel;
		this.cname = cname;
		this.point = point;
		this.buy = buy;
		this.grade = grade;
	}

	@Override
	public String toString() {
		String resulte = "[°í°´ID] : " + cno;
		resulte += "  [°í°´¿¬¶ôÃ³] : " + ctel;
		resulte += "  [°í°´¸í] : " + cname;
		resulte += "  [Æ÷ÀÎÆ®] : " + point;
		resulte += "  [±¸¸ÅÃÑ¾×] : " + buy;
		resulte += "  [°í°´µî±Þ] : " + grade + "\n";
		
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
