package com.tj.ex1bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1. 파일 스트림을 연다. 2. read 한다.
public class InputStreamEx01 {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream(
					"C:/Users/Leos/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/inTest.txt");
			while (true) {
				int temp = is.read(); // 파일을 1byte 씩 읽어온다. 읽어오는 값이 없다면 -1 을 반환한다.
				if (temp == -1) { // 파일의 끝까지 읽었다면 반복문 탈출 (temp 에 -1 이 들어옴)
					break;
				} else {// 파일의 끝이면 while 반복문 빠져나감.
				//  System.out.println("데이터 : " + (char) temp + " ASCII : " + temp);
					System.out.print((char)temp);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "파일을 찾지 못했습니다.");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "파일을 읽지 못했습니다.");
		} finally {
			try {
				if (is != null) { is.close(); } // 값이 있을때문 닫는 작업을 해야한다.
			} catch (IOException e) {
				System.out.println(e.getMessage()+"read 오류");
			}
		}
		System.out.println();
		System.out.println("프로그램 끝");
	}
}
