package com.tj.ex1bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
// 1 InputStream(image.jpg) , OutPutStream (image_copy.jpg) ��ü ����
// 2. inputStream���� read �ؼ� temp ������ �־� temp ���� ������ outputStream ���� write
// ��  2�� ������ temp �� -1 �� �ɶ����� ���
// 3. inputStream ��ü�� outputSteam ��ü�� close() �Ѵ�.
public class FileCopyStep1 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			out = new FileOutputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image_copy.jpg");
			int i = 0;
			while (true) {
				int temp = in.read(); // read() ��ȯ��  int �̱� ������ temp�� int �� �޴´�.
				i++;
				if (temp == -1) { break; }
				else {
					out.write(temp);
				}
			}
			System.out.println("�ݺ����� Ƚ���� : " + i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(out != null) { out.close(); }
				if(in != null) { in.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
				
	}
}
