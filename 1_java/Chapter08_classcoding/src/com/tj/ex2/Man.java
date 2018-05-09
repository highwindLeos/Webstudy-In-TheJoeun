package com.tj.ex2;
// 나이 키 몸무게 전화번호 (데이터=속성=필드),BMI 지수 계산 (메소드)
// Man m1 = new Man(); 이 안됨. (다른 생성자가 있다면 만들지 않음)
public class Man {
	private int age; //나이
	private int height; // 키
	private int weight; // 몸무게
	private String phonenumber; // 전번
	
	public Man() { } // 기본 생성자. (매개변수 없는 생성자)
	
	public Man(int age, int height, int weight,String phonenumber) {
		System.out.println("매개변수가 4개인 생성자.");
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phonenumber = phonenumber;
	}
	
	public Man(int height, int weight) {
		System.out.println("매개변수가 2개인 생성자.");
		this.height = height;
		this.weight = weight;
	}
	
	// BMI 지수 계산식 : 60 / (1.7*1.7)
	public double calcluateBMI() {
		double resulte = weight / ((height*0.01) * (height*0.01));
		return resulte;
	}
	
	// setter and getter
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
}
