package com.tj.ex5;
// 결과 : 이름 = 홍길동 나이 = 20 성별 = m

//			이름 = 홍길순 나이 19 성별 = f
// 데이터 (Name, age, gender)
// 메소드 (void out() - 이름 = 홍, 나이 = 20, 성별 = m) 

public class Person {

	private String name;
	private int age;
	private String gender;

	public Person() {}

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	} // 여기까지 생성자 메소드.
	
	// 사용자 정의 함수.
	public void printPerson() {
		System.out.println("이름은 : " + name + " 나이는 : " + age + " 성별은 : " + gender);
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
