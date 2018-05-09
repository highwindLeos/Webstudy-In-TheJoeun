package com.tj.ex11;

public class Student {
	private static int count = 1; // 초기값은 1 공유되는 Class 변수

	private int no;
	private String name;
	private int kor;
	private int math;
	private int eng;
	private int total;
	private double avg;

	public Student() {
	}

	public Student(String name, int kor, int math, int eng) {

		no = count++; // 객체가 만들어질때 만다 1씩 증가시켜줌.

		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.total = kor + math + eng;
		this.avg = (double) (total / 3.0);
	}

	// method
	public void printStudent() {
		System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\t %.2f\t \n", 
							no, name, kor, math, eng, total, avg);
	}

	public String printOut() {
		avg = Math.round(avg); 
		String resulte = no + "\t" + name + "\t" + kor + "\t" + math + "\t" + eng + "\t" + total + "\t" + avg;
		return resulte;
	}

	// getter,setter
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Student.count = count;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

}
