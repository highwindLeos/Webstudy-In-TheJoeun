package com.tj.ex5;

public class PersonMain {

	public static void main(String[] args) {

		// Person ps1 = new Person("LeeDays", 30, "m");
		// Person ps2 = new Person("ChaCha", 28, "f");
		// Person ps3 = new Person("Days", 29, "m");
		// Person ps4 = new Person("Oscar", 34, "f");

		Person[] ps = { new Person("LeeDays", 30, "m"), 
				new Person("ChaCha", 28, "f"), 
				new Person("Days", 29, "m"),
				new Person("Oscar", 34, "f"), 
				new Person("Order", 24, "m") }; // 객체를 Class (레퍼런스) 변수에 담는다. (생성과 동시에 입력.)

		/*
		 * for (Person p : ps) { // 배열출력. p.printPerson(); }
		 */

		for (int i = 0; i < ps.length; i++) {
			ps[i].printPerson();
		}

	}

}
