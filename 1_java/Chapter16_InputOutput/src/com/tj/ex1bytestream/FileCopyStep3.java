package com.tj.ex1bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
// 1 InputStream(image.jpg) , OutPutStream (image_copy.jpg) ��ü ����
// 2. inputStream���� read �ؼ� temp ������ �־� temp ���� ������ outputStream ���� write
// ��  2�� ������ temp �� -1 �� �ɶ����� ���
// 3. inputStream ��ü�� outputSteam ��ü�� close() �Ѵ�.
public class FileCopyStep3 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			File orignalFile = new File(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			in = new FileInputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			out = new FileOutputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image_copy3.jpg");
			// �о���� ������ File class ��ü�� ������ �ش� ����� ������ �Լ��� �ִ�.
			// length() ��ȯ���� long �̴�. �׷��� int ��  casting
			byte[] btemp = new byte[(int) orignalFile.length()]; // ������ �о� ���϶� byte ������ ���� �´�. 
			while (true) {
				int count = in.read(btemp); // ��ȯ��  int �̱� ������ temp�� int �� �޴´�. �����ð��� ������ -1 �� ��ȯ.
				if (count == -1) { 
					break; 
				} else {
					out.write(btemp, 0, count); // write( �����͹迭, ������, ������ ������);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(out != null) { out.close(); } // in ���� out �� �����ٸ� �ݴ°��� out -> in ������� �ݾ���.
				if(in != null) { in.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
				
	}

}
