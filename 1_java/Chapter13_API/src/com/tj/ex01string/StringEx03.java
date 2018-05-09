package com.tj.ex01string;

public class StringEx03 {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = " �̰��� �ڹٴ� ";
		
		System.out.println(str3.trim()); // �յ��� ������ �����Ѵ�. ���ڿ� �߰��� ������ �״�� �д�.
		System.out.println(str1.replace('a', 'Z')); // ù��° �Ű����� �ι�° �Ű������� �ٲ۴�. : ZbcXZbc
		System.out.println(str1.replaceAll("a", "�ȳ�")); // ù��° �Ű����� �ι�° �Ű������� �ٲ۴�. : �ȳ�bcX�ȳ�bc
		System.out.println(str1.replaceFirst("a", "�ȳ�")); // ó������ ��ġ�Ǵ� ù��° �Ű����� �ι�° �Ű������� �ٲ۴�. : �ȳ�bcXabc
		
		System.out.println(str1.concat(str2)); // concat(); ���ڿ��� �ٿ��� ���. abcXabcabcXabc
		System.out.println(str1.substring(3)); // �Է��� �������� 3 ���ķ� ���ڿ��� ������ �����.
		System.out.println(str1.substring(3, 6)); // �Է��� �������� 3 ���ķ� ���ڿ��� index 6 ���� �����.
		System.out.println(str1.length()); // ���ڼ��� ��ȯ. (index�� ���̸� ��ȯ) : 7
		System.out.println(str1.toUpperCase()); // ���� case �� �빮�ڷ� �ٲ�
		System.out.println(str1.toLowerCase()); // ���� case �� �ҹ��ڷ� �ٲ�
		System.out.println(str1.charAt(3)); // �Է��� ���� index �� ���ڸ� ��ȯ��. : X
		System.out.println(str1.equals(str2)); // ���ڿ��� ���� ���Ѵ�. (��ü�� ������) : true
		System.out.println(str1.equalsIgnoreCase(str2)); // ������ case �� �����ϰ� ���� �� �ؼ� ������ true
		System.out.println(str1.indexOf("X")); // �ش� �Է� ���ڰ� ��� �ε��� ���� ��ȯ : 3 �ش� ���ڰ� ������ -1 ���� ��ȯ.
		
		String str4 = "�ɳ����� �ɳ��� ���� �ǿ� �ɳ���";
		System.out.println(str4.indexOf("��")); // ó������ ���� ���� ��ȯ. �ڿ� � ���� ���� �ִ����� Ȯ�� ���Ѵ�. : 0
		System.out.println(str4.indexOf("��", 3)); // �ε��� 3������ ã�Ƽ� ���� ��ȯ. (2��° ���ڰ��� ����) : 5
		System.out.println(str4.lastIndexOf("��")); // �ڿ��� ���� ã�Ƽ� ���� ���� �ε����� ��ȯ : 15
		System.out.println(str4.lastIndexOf("��", 8)); // �ڿ��� 8��°���� ã�Ƽ� ���� ���̸� �ε����� ��ȯ : 5
		
		System.out.println();
		// ���� ���� 2��.
		StringEx01 ex01 = new StringEx01();
		//com.tj.ex01string.StringEx01
		System.out.println(ex01.getClass().getName()); // Ŭ�����̸��� ��ȯ (��Ű�� �����)
		// StringEx01 �� ��ȯ�ϰ� �϶�.
		String stemp = ex01.getClass().getName();
		int idx = stemp.lastIndexOf('.'); // ������ . �� �ε��� �� �����´�.
		System.out.println(stemp.substring(idx+1)); // �ش繮�ڿ���   . + 1 ��° ���� ���
		
		idx = stemp.indexOf('.'); // ù . �� �ִ� �ε����� ��ȯ
		System.out.println(stemp.substring(0, idx)); // com �� ��� 0���� 3�ε��������� ���ڿ��� ���
	}//main()

}
