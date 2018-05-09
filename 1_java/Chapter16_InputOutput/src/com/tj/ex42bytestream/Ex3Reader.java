package com.tj.ex42bytestream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 1 ������ ���� (��Ʈ�� ��ü�� ����) 1 �д´�. 3 ������ �ݴ´�.(��Ʈ�� ��ü.close())
public class Ex3Reader {

	public static void main(String[] args) {
		Reader reader = null; // ������ ���� ��ü ���� �Ҵ�.
		BufferedReader bReader = null; // Reader �� ������Ȱ�� ��Ʈ��
		
		//1 ������ ����.
		try {
			reader = new FileReader("files/inTest.txt");
			bReader = new BufferedReader(reader);
			
			while (true) {
				String linedata = bReader.readLine();// ���پ� �о�´�.
				if (linedata == null) {
					break; // �ݺ��� Ż��
				} else {
					System.out.println(linedata);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "���� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "�б� ����");
		} finally {
			try {
				bReader.close();
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
