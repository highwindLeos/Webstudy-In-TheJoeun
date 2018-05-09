package com.tj.ex1bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. ���� ��Ʈ���� ����. 2. read �Ѵ�.
public class InputStreamEx01 {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream(
					"C:/Users/Leos/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/inTest.txt");
			while (true) {
				int temp = is.read(); // ������ 1byte �� �о�´�. �о���� ���� ���ٸ� -1 �� ��ȯ�Ѵ�.
				if (temp == -1) { // ������ ������ �о��ٸ� �ݺ��� Ż�� (temp �� -1 �� ����)
					break;
				} else {// ������ ���̸� while �ݺ��� ��������.
				//  System.out.println("������ : " + (char) temp + " ASCII : " + temp);
					System.out.print((char)temp);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "������ ã�� ���߽��ϴ�.");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "������ ���� ���߽��ϴ�.");
		} finally {
			try {
				if (is != null) { is.close(); } // ���� �������� �ݴ� �۾��� �ؾ��Ѵ�.
			} catch (IOException e) {
				System.out.println(e.getMessage()+"read ����");
			}
		}
		System.out.println();
		System.out.println("���α׷� ��");
	}
}
