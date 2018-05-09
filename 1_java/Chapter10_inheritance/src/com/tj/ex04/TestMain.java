package com.tj.ex04;

public class TestMain {

	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println("------------------------------");
		Child1 child1 = new Child1();
		System.out.println("------------------------------");
		Child2 child2 = new Child2();
		System.out.println("------------------------------");
		GrandChild grandchild = new GrandChild();

		System.out.println(parent.p); // 가능
		System.out.println(child1.p); // 상속 받아서 가능
		System.out.println(child1.c1);
		System.out.println(child2.p); // 상속 받아서 가능
		System.out.println(child2.c2);
		System.out.println(grandchild.p); // 상속받아서 가능
		System.out.println(grandchild.g); // 상속 받아서 가능
		// System.out.println(grandchild.c2); // 불가능
		System.out.println(grandchild.equals(grandchild)); // 가능

	}

}
