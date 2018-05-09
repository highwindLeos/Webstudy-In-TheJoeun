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
		InputStream is = null; // 스트림 변수는 보통 초기화 해놓고 사용한다.
		DataInputStream dis = null; // 스트림 변수는 보통 초기화 해놓고 사용한다.ㄴㄴㄴ
		File file = new File(
		"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/dataFile.dat");
		
		ArrayList<Baby> baby = new ArrayList<Baby>(); // 제네릭 객체 타입.
		
		try {
			is = new FileInputStream(file);
			dis = new DataInputStream(is);
			
			while(true) {
				
				String name = dis.readUTF(); // 문자열을 읽어와서 반환하는 DataInput 함수.
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
				if(dis != null) {dis.close(); } // 파일 입출력 닫음.
				if(is != null) { is.close(); } // 파일 입출력 닫음.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} //try catch
		}
		
		for (Baby bt : baby) {
			System.out.println(bt);
		} // ArrayList 는 확장 for 문으로 출력이 용이하다.
	}
}
