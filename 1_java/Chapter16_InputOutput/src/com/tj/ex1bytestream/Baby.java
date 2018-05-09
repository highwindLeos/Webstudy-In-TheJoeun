package com.tj.ex1bytestream;

public class Baby {
	
	private String name;
	private double avg;
	private int hak;
	
	public Baby() {}

	public Baby(String name, double avg, int hak) {
		this.name = name;
		this.avg = avg;
		this.hak = hak;
	}
	
	// 출력  오버라이드
	@Override
	public String toString() {
		return "[name=" + name + ", avg=" + avg + ", hak=" + hak + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}
	
}
