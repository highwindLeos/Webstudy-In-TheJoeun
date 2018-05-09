package com.tj.ex04Studentmanage;

/*
 * (data) �й� �̸� ���� �а�
 * method modify(��ɹ�ȣ, �ٲ� ������) // ������
 * out() // ����� ���ڿ� ����
 */
public class Student {
	private int studentNum; // ������ (�Ӽ�, �ʵ�, ����)
	private String name;
	private int age;
	private String major;

	// ������.
	public Student() {	} // �ٸ� �����ڸ� ���������� ���ε� �⺻�����ڸ� ������ ���´�.

	public Student(int studentNum, String name, int age, String major) {
		this.studentNum = studentNum;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	// Student st = new Student(20180301,"ȫ�浿", 20, "�İ�");
	
	// ����� �Լ�
	 public void modify(int function, String data) { // 1. �̸��ٲٱ� 2. ���̹ٲٱ� 3. �����ٲٱ�
		 //function == 1 : name = data
		 //function == 2 : age = data (int �� ����ȯ)
		 //function == 3 : major = data
		 
		 switch(function) {
		 	case 1:
		 		name = data; 
		 		break;
		 	case 2:
		 		age = Integer.parseInt(data); 
		 		break; //Integer.parseInt(data) : �Ű������� �ִ� ���� ������ �ٲٴ� ���.
		 	case 3:
		 		major = data; 
		 		break;		 
		 }// switch
		 
	 }//modify();
	 
//	 public void modify(int function, int agedata) { // 1. �̸��ٲٱ� 2. ���̹ٲٱ� 3. �����ٲٱ�
//		 
//	 }
	 
	 public String out() {
		 String resulte = "(�й�) " + studentNum + " (�̸�) " + name + 
				 		  " (����) "+ age +" (����) " + major;
		 return resulte;
	 }
	 
	 // getter setter
	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	 
	 

}
