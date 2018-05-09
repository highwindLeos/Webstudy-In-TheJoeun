package com.tj.ex1bytestream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex3 {
	public static void main(String[] args) {
		OutputStream os = null;
		DataOutputStream dos = null;
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/dataFile.dat");
		
		try {
			
			os = new FileOutputStream(file, true); // ���� ��ü�� �־  �ƿ�ǲ�� ����. true �� �����ϸ� ������ ����� �ʰ� �߰���
			dos = new DataOutputStream(os); // ���� ��Ʈ��
			
			dos.writeUTF("�̷���"); // �Էµ� ���ڿ��� ���Ͽ� ����.
			dos.writeDouble(95.2); // �Էµ� �Ǽ��� ���Ͽ� ����.
			dos.writeInt(6); // �Էµ� ������ ���Ͽ� ����.
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()+"���� ���� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage()+"���� ���� ����");
		} finally {
			try {
				if (os != null ) { os.close(); }
				if (dos != null ) { dos.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
