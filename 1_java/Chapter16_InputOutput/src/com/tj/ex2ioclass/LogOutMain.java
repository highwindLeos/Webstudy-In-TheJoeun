package com.tj.ex2ioclass;

import java.io.*;
import java.util.*;
// do while 문을 이용하여 id ip time 을 받아 데이터 파일로 출력.
// 데이터 파일의 정보를 arrayList 에 입력받아 콘솔에 출력
public class LogOutMain {

	public static void main(String[] args) {
		
		InputStream is = null;
		DataInputStream dis = null;
		
		ArrayList<User> users = new ArrayList<User>(); //user 참조형 만 들어가는 ArrayList
		
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/data.txt");
		
		String id, ip; int time;
		
		try {
			is = new FileInputStream(file);
			dis = new DataInputStream(is);
			// 데이터를 가져와야 함. id ip time
			while (true) {
				id = dis.readUTF(); // readUTF() 문자열을 읽어올때 사용
				ip = dis.readUTF();
				time = dis.readInt(); // readInt() 정수값을 읽어올때 사용
				
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
		} // 파일 출력 try-catch-finally 
		// users 내용을 출력해본다.
		for(User ut : users) {
			System.out.println(ut);
		}
		
	}

}
