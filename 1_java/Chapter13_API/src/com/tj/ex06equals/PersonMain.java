package com.tj.ex06equals;

public class PersonMain {
	public static void main(String[] args) {
		
		Person person1 = new Person("920112-2", "ȫ�浿");
		Person person2 = new Person("920112-2", "ȫ�浿");
		Person person3 = new Person("930112-1", "ȫ�浿");
		Person person4 = new Person("930112-1", "�踶��");
		
		System.out.println("p1 �� �ؽ��ڵ� : " + person1.hashCode());  // �ؽ� �ڵ带 ��ȯ.
		System.out.println("p2 �� �ؽ��ڵ� : " + person2.hashCode());
		
		if(person1.equals(person2)) { // �ٸ� ��ü�̱� ������ �ٸ� ��� �׷��� �������� equals() �� Ȯ���Ѵ�.
			System.out.println("p1 �̶� p2 �� �������");
		} else {
			System.out.println("p1 �̶� p2 �� �ٸ����");
		}	
		
		if(person1.equals(person3)) { // �ٸ� ��ü�̱� ������ �ٸ� ��� �׷��� �������� equals() �� Ȯ���Ѵ�.
			System.out.println("p1 �̶� p2 �� �������");
		} else {
			System.out.println("p1 �̶� p2 �� �ٸ����");
		}	
		
		if(person3.equals(person4)) { // �ٸ� ��ü�̱� ������ �ٸ� ��� �׷��� �������� equals() �� Ȯ���Ѵ�.
			System.out.println("p3 �̶� p4 �� �������");
		} else {
			System.out.println("p3 �̶� p4 �� �ٸ����");
		}	
		
	}

}
