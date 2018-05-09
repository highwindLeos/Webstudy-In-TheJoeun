package com.tj.ex1bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
// 1 InputStream(image.jpg) , OutPutStream (image_copy.jpg) ��ü ����
// 2. inputStream���� read �ؼ� temp ������ �־� temp ���� ������ outputStream ���� write
// ��  2�� ������ temp �� -1 �� �ɶ����� ���
// 3. inputStream ��ü�� outputSteam ��ü�� close() �Ѵ�.
public class FileCopyStep2 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			out = new FileOutputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image_copy2.jpg");
			int i = 0;
			byte[] btemp = new byte[1024]; // ������ �о� ���϶� byte ������ ���� �´�. 
			while (true) {
				int count = in.read(btemp); // ��ȯ��  int �̱� ������ temp�� int �� �޴´�. �����ð��� ������ -1 �� ��ȯ.
				i++;
				if (count == -1) { break; }
				else {
					out.write(btemp, 0, count); // write( �����͹迭, ������, ������ ������);
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
