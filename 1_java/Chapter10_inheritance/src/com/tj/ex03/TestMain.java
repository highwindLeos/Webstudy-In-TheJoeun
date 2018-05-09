package com.tj.ex03;

public class TestMain {

	public static void main(String[] args) {

		S s = new S();
		// A s = new S(); // 상위 타입으로 가능하나 하위 타입으로는 불가능.
		S a = new A(); // 타입의 통일화. = 다형성
		S b = new B();
		S c = new C();

		S[] obj = { a, b, c }; // S 형 변수 이기때문에 a,b,c 는 배열로 생성이 가능하다.

		System.out.println("s 의 s : " + s.s); //

		for (S o : obj) {
			System.out.println(o.s);
		}

		// for (int i = 0; i<obj.length; i++) {
		// System.out.println(obj[i].s);
		// }

	}

}
