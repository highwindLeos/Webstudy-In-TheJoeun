package com.tj.ex3file;

import java.io.File;

public class Ex1File {

	public static void main(String[] args) {
		String path = "files/intest.txt";
		File file = new File(path); 
		
		if (file.exists()) { // ������ �����ϴ��� ���θ� ���� �����ϸ� true
			System.out.println("�����ϴ� �����̶� ���ﲲ��.");
			file.delete(); // ������ �����Ѵ�.
			System.out.println("���� ��������.");
		} else {
			System.out.println("�������� �ʴ� ���� �Դϴ�.");
		}
	}

}
