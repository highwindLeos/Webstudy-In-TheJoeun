package com.tj.ex42bytestream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex4KeyBoardFile {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader bReader = null;
		BufferedReader keyboard = null; // Ű���� �Է��� ���� ��Ʈ��.
				
		keyboard = new BufferedReader(new InputStreamReader(System.in)); //Ű����� ���پ� �Է¹����� �ִ� ��ǲ��Ʈ��
		// ���� ���� ���ϸ� �Է½� ch17 root ������ ���Ϸ� �ν�.
		System.out.print("���ϴ� ������(���� ����)? "); 	
		try {
			String filename = keyboard.readLine();
			File file = new File(filename);
			if (file.exists()) { // �����ϴ� ������ ��� �Է¹޾Ƽ� ó��
				reader = new FileReader(file);
				bReader = new BufferedReader(reader);
				
				while (true) {
					String linedata = bReader.readLine();// ���پ� ��ȯ�ؼ� ���ڿ��� ����.
					if (linedata == null) {
						break;
					} else {
						System.out.println(linedata);
					}
				}
			} else {
				System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bReader.close();
				reader.close();
			} catch (IOException e) {
//				System.out.println(e.getMessage());
			}
		}// try catch finally
	} // main
}
