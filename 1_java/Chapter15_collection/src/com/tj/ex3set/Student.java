package com.tj.ex3set;

public class Student {
	
	private String name;
	private int grade;
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return  name + " : " + grade;
	}
	
	@Override
	public int hashCode() {
		// 이렇게 코딩하면 객체생성이 같은 해쉬값이라도 값이 같다면 같은 객체로 인식. 
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) { // ob1.equals(ob2)
		String meTostr = toString(); // 이 클래스의 toString()
		String objToStr = obj.toString(); 
		
		return meTostr.equals(objToStr);
	}

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

}
