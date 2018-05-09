package com.tj.ex1bytestream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Ex4 {
	public static void main(String[] args) {
		InputStream is = null; // ��Ʈ�� ������ ���� �ʱ�ȭ �س��� ����Ѵ�.
		DataInputStream dis = null; // ��Ʈ�� ������ ���� �ʱ�ȭ �س��� ����Ѵ�.������
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/dataFile.dat");
		
		ArrayList<Baby> baby = new ArrayList<Baby>(); // ���׸� ��ü Ÿ��.
		
		try {
			is = new FileInputStream(file);
			dis = new DataInputStream(is);
			
			while(true) {
				
				String name = dis.readUTF(); // ���ڿ��� �о�ͼ� ��ȯ�ϴ� DataInput �Լ�.
				double avg = dis.readDouble();
				int hak = dis.readInt();
				
				baby.add(new Baby(name, avg, hak));
 			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dis != null) {dis.close(); } // ���� ����� ����.
				if(is != null) { is.close(); } // ���� ����� ����.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} //try catch
		}
		
		for (Baby bt : baby) {
			System.out.println(bt);
		} // ArrayList �� Ȯ�� for ������ ����� �����ϴ�.
	}
}
