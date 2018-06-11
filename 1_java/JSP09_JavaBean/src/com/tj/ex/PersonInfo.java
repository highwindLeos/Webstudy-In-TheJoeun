package com.tj.ex;

public class PersonInfo {
	
	private String name;
	private int age;
	private String gender;
	
	public PersonInfo() {} // 자바빈으로 쓸때는  반드시 매개변수가 없는 생성자가 필요하다.
	
	// getter setter 도 꼭 필요하다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
