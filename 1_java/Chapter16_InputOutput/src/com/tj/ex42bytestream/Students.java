package com.tj.ex42bytestream;

public class Students {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private double avg;
	
	public Students() {}
	
	public Students(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		avg = (kor+eng+mat)/3.0;
	}


	public String getName() {
		return name;
	}


	public int getKor() {
		return kor;
	}


	public int getEng() {
		return eng;
	}


	public int getMat() {
		return mat;
	}


	public double getAvg() {
		return avg;
	}

}
