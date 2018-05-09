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
			
			os = new FileOutputStream(file, true); // 파일 객체를 넣어서  아웃풋을 생성. true 로 지정하면 파일을 덮어쓰지 않고 추가함
			dos = new DataOutputStream(os); // 보조 스트림
			
			dos.writeUTF("이레오"); // 입력된 문자열을 파일에 쓴다.
			dos.writeDouble(95.2); // 입력된 실수를 파일에 쓴다.
			dos.writeInt(6); // 입력된 정수를 파일에 쓴다.
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()+"파일 쓰기 실패");
		} catch (IOException e) {
			System.out.println(e.getMessage()+"파일 쓰기 실패");
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
