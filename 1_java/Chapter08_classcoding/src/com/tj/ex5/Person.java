package com.tj.ex5;
// ��� : �̸� = ȫ�浿 ���� = 20 ���� = m

//			�̸� = ȫ��� ���� 19 ���� = f
// ������ (Name, age, gender)
// �޼ҵ� (void out() - �̸� = ȫ, ���� = 20, ���� = m) 

public class Person {

	private String name;
	private int age;
	private String gender;

	public Person() {}

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	} // ������� ������ �޼ҵ�.
	
	// ����� ���� �Լ�.
	public void printPerson() {
		System.out.println("�̸��� : " + name + " ���̴� : " + age + " ������ : " + gender);
	}
	
	//  setter
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
