package com.tj.ex01string;

public class StringBilderEx {
	public static void main(String[] args) {
		String str = "abc";
		
		StringBuilder strB = new StringBuilder("abc"); // ���ڿ��� �����ϴ� �ٸ� ��ü
		str = str.concat("def");
		System.out.println(str);
		
		System.out.println(strB.append("def")); // ���ڿ��� �߰����ش�. abcdef
		strB.insert(1, 'X'); // ���ڸ� �ش� �ε����� �߰��Ѵ�. aXbcdef
		System.out.println(strB);
		strB.insert(1, "XX"); // ���ڿ��� �ش� �ε����� �߰��Ѵ�. aXXXbcdef
		System.out.println(strB);
		strB.delete(1, 4);	// 1��°���� 4��° �ձ��� ���� (index : 1~3 )
		System.out.println(strB); // abcdef
		System.out.println("strB �� capa?" + strB.capacity()); //  19 (�������)
		strB.append("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("strB �� capa? " + strB.capacity()); //  44 (�������) ���ڸ� �߰��ص� �˾Ƽ� �þ��.
		strB.ensureCapacity(100);	// �������� ��������� �÷��ش�.
		System.out.println("strB �� capa? " + strB.capacity()); 
		
	}
}
