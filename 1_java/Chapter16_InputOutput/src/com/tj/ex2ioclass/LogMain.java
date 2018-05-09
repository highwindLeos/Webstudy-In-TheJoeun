package com.tj.ex2ioclass;

import java.io.*;
import java.util.*;
// do while 문을 이용하여 id ip time 을 받아 데이터 파일로 출력.
// 데이터 파일의 정보를 arrayList 에 입력받아 콘솔에 출력
public class LogMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		String id, ip; int time;
		String fn; // 기능 선택 변수
		
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/data.txt");
		
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			os = new FileOutputStream(file,true); // 파일의 내용을 추가한다. 덮어쓰지 않음. 기본은 false
			dos = new DataOutputStream(os);
			do {
				System.out.println("접속자가 더 있나요(Y/N)");
				fn = sc.next();
				if(fn.equalsIgnoreCase("n")) {
					break; // 반복문 탈출
				}else if (fn.equalsIgnoreCase("y")) { //대소문자를 구분하지 않고 입력된 문자를 비교해서 논리값을 리턴한다.
					System.out.print("id는?");
					dos.writeUTF(sc.next());
					System.out.print("ip는?");
					dos.writeUTF(sc.next());
					System.out.print("접속시간은 (0~24시)?");
					dos.writeInt(sc.nextInt());
				}
			}while(true);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) { dos.close(); }
				if (os != null) { os.close(); }
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // 파일 출력 try-catch-finally 
		
	}

}
