package com.tj.ex7homework;
// �����ͺ��̽����� ��¹޾ƿ� Ÿ���� ����. 
public class Person { // DTO = ����, �������Լ�(), setter(), tostring()
	
	private String rank;
	private String nameId;
	private String jname;
	private int kor;
	private int eng;
	private int mat;
	private int sum;
	
	public Person(){}

	public Person(String rank, String nameId, String jname, int kor, int eng, int mat, int sum) {
		this.rank = rank;
		this.nameId = nameId;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}

	@Override
	public String toString() {
		String temp = rank + "\t" + nameId + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + sum; 
		return temp;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}
