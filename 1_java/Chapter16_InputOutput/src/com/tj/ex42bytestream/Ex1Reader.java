package com.tj.ex42bytestream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 1 ������ ���� (��Ʈ�� ��ü�� ����) 1 �д´�. 3 ������ �ݴ´�.(��Ʈ�� ��ü.close())
public class Ex1Reader {

	public static void main(String[] args) {
		Reader reader = null; // ������ ���� ��ü ���� �Ҵ�.
		try {
			reader = new FileReader("files/inTest.txt");
			while (true) {
				int count = reader.read(); // 2����Ʈ �� �����´�. �����ð� ���ٸ� -1�� ����.
				if (count == -1) {
					break;
				} else {
					System.out.print((char)count); // ����ȯ�ؼ� �ѷ��ش�. ��ȯ�� int �̱� ������.
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try catch finally
	}
}
