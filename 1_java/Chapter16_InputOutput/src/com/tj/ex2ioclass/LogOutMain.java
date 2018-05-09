package com.tj.ex2ioclass;

import java.io.*;
import java.util.*;
// do while ���� �̿��Ͽ� id ip time �� �޾� ������ ���Ϸ� ���.
// ������ ������ ������ arrayList �� �Է¹޾� �ֿܼ� ���
public class LogOutMain {

	public static void main(String[] args) {
		
		InputStream is = null;
		DataInputStream dis = null;
		
		ArrayList<User> users = new ArrayList<User>(); //user ������ �� ���� ArrayList
		
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/data.txt");
		
		String id, ip; int time;
		
		try {
			is = new FileInputStream(file);
			dis = new DataInputStream(is);
			// �����͸� �����;� ��. id ip time
			while (true) {
				id = dis.readUTF(); // readUTF() ���ڿ��� �о�ö� ���
				ip = dis.readUTF();
				time = dis.readInt(); // readInt() �������� �о�ö� ���
				
				users.add(new User(id, ip, time));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
//			System.out.println(e.getMessage());
		} finally {
			try {
				if (dis != null) { dis.close(); }
				if (is != null) { is.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // ���� ��� try-catch-finally 
		// users ������ ����غ���.
		for(User ut : users) {
			System.out.println(ut);
		}
		
	}

}
