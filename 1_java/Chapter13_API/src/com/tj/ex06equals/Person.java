package com.tj.ex06equals;

// 이름 주민번호
public class Person {
	private String juminNo;
	private String name;

	public Person() {
	}

	public Person(String juminNo, String name) {
		this.juminNo = juminNo;
		this.name = name;
	}

	@Override // object.equals() 재정의
	public boolean equals(Object obj) {
		// boolean resulte = false;
		// p1.equals(p2) -> p1 은 this 고 p2 는 obj
		// if(this == obj) { resulte = true; }
		// else obj 가 Person 형인지 확인후 obj를 Person형으로 형변환후
		// return this.주민번호 == obj.주민번호
		/*
		 * if(this == obj) { resulte = true; } else
		 */
		// this.juminNo 랑 ((Person)obj).juminNo 같은지 다른지를 return

		if (obj != null && obj instanceof Person) { // obj 가 값이 있고 Person 형인지 확인 (true) 
			// j = 주민 번호 맞는지
			boolean jumin = juminNo.equals(((Person) obj).juminNo);
			// n = 이름이 맞는지 
			boolean na = name.equals(((Person)obj).name);
			
			return jumin && na;	
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[주민번호] : " + juminNo + "\t[이름] : " + name;
	}

}
