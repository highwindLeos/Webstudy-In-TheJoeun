package com.tj.ex11person;

public class Main {

	public static void main(String[] args) {
		
		Person st1 = new Student("A01","강유미","JAVA반");
		Person st2 = new Student("A02","이미라","JAVA반");
		Person sf1 = new Staff("A03","이유라","취업 지원팀");
		Person sf2 = new Staff("A04","강주식","행정팀");
		Person ga1 = new Gangsa("A05","이길동","객체지향");
		
		Person[] p = {st1,st2,sf1,sf2,ga1}; // 객체를 배열로 올림
		
		for(Person ptemp : p) {
			ptemp.print();
		}
	}

}
