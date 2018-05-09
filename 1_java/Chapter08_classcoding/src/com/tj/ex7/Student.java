package com.tj.ex7;

public class Student {

	private String name;
	private int kor;
	private int math;
	private int eng;
	private int sum;
	private double avg;

	public Student() {

	}

	public Student(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		sum = kor + math + eng;
		avg = sum / 3.0;
	}
	// 생성자 메소드들.

	public int sum() {
		sum = kor + math + eng;
		return sum;
	}

	public double avg() {
		sum = kor + math + eng;
		avg = (double) sum / 3;
		return avg;
	}

	
	// getter setter
	public void show() {
		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.1f \n", 
							name, kor, math, eng, sum, avg);
	}

	public int getKor() {
		return kor;
	}

	public int getMath() {
		return math;
	}

	public int getEng() {
		return eng;
	}
	
	public int getSum() {
		return sum;
	}


	
	
}
