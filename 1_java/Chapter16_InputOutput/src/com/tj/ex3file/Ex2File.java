package com.tj.ex3file;

import java.io.File;

public class Ex2File {
	public static void main(String[] args) {
		File dir = new File("."); // ���� ���丮.
		String[] dirlist = dir.list(); // ������ ����� ��� ������ �迭�� ��´�.
		
//		for (String dt : dirlist) {
//			System.out.println(dt);
//		}
		
		File[] files = dir.listFiles(); // ���ϰ� ���丮�� ����� ��ȯ�ؼ� File �迭�� �ִ´�.
		System.out.println("���ϸ�\t\t ���� \t ����");
		for (int i = 0; i< files.length; i++) {
			
			if(files[i].getName().length() >= 7) { // �̸��� ���̰� 7�� �̻��̶�� true
				System.out.print(files[i].getName() +"\t"); // �̸��� �����´�.
			} else {
				System.out.print(files[i].getName() +"\t\t"); // �̸��� �����´�.
			}
//			System.out.print(files[i].isDirectory() ? "����" : "����"); // �������� Ȯ���Ѵ�.
			
			if (files[i].isDirectory()) { // �������� Ȯ���Ѵ�.
				System.out.print("���� \t");
			} else {
				System.out.print("���� \t");
			}
			System.out.println(files[i].length());//���̸� ���
		}
	}
}
