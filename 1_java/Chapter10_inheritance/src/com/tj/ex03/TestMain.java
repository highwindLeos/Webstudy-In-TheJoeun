package com.tj.ex03;

public class TestMain {

	public static void main(String[] args) {

		S s = new S();
		// A s = new S(); // ���� Ÿ������ �����ϳ� ���� Ÿ�����δ� �Ұ���.
		S a = new A(); // Ÿ���� ����ȭ. = ������
		S b = new B();
		S c = new C();

		S[] obj = { a, b, c }; // S �� ���� �̱⶧���� a,b,c �� �迭�� ������ �����ϴ�.

		System.out.println("s �� s : " + s.s); //

		for (S o : obj) {
			System.out.println(o.s);
		}

		// for (int i = 0; i<obj.length; i++) {
		// System.out.println(obj[i].s);
		// }

	}

}
