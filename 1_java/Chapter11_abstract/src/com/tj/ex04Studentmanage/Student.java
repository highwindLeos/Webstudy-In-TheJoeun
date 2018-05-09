package com.tj.ex04Studentmanage;

/*
 * (data) 학번 이름 나이 학과
 * method modify(기능번호, 바꿀 데이터) // 변경기능
 * out() // 출력할 문자열 리턴
 */
public class Student {
	private int studentNum; // 데이터 (속성, 필드, 변수)
	private String name;
	private int age;
	private String major;

	// 생성자.
	public Student() {	} // 다른 생성자를 정의했을때 별로도 기본생성자를 생성해 놓는다.

	public Student(int studentNum, String name, int age, String major) {
		this.studentNum = studentNum;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	// Student st = new Student(20180301,"홍길동", 20, "컴공");
	
	// 사용자 함수
	 public void modify(int function, String data) { // 1. 이름바꾸기 2. 나이바꾸기 3. 전공바꾸기
		 //function == 1 : name = data
		 //function == 2 : age = data (int 로 형변환)
		 //function == 3 : major = data
		 
		 switch(function) {
		 	case 1:
		 		name = data; 
		 		break;
		 	case 2:
		 		age = Integer.parseInt(data); 
		 		break; //Integer.parseInt(data) : 매개변수에 있는 값을 정수로 바꾸는 기능.
		 	case 3:
		 		major = data; 
		 		break;		 
		 }// switch
		 
	 }//modify();
	 
//	 public void modify(int function, int agedata) { // 1. 이름바꾸기 2. 나이바꾸기 3. 전공바꾸기
//		 
//	 }
	 
	 public String out() {
		 String resulte = "(학번) " + studentNum + " (이름) " + name + 
				 		  " (나이) "+ age +" (전공) " + major;
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
