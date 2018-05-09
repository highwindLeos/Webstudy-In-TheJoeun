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
		// �̷��� �ڵ��ϸ� ��ü������ ���� �ؽ����̶� ���� ���ٸ� ���� ��ü�� �ν�. 
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) { // ob1.equals(ob2)
		String meTostr = toString(); // �� Ŭ������ toString()
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
