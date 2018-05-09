package com.tj.ex42bytestream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 1 파일을 연다 (스트림 객체를 생성) 1 읽는다. 3 파일을 닫는다.(스트림 객체.close())
public class Ex3Reader {

	public static void main(String[] args) {
		Reader reader = null; // 파일을 여는 객체 변수 할당.
		BufferedReader bReader = null; // Reader 의 보조역활의 스트림
		
		//1 파일을 연다.
		try {
			reader = new FileReader("files/inTest.txt");
			bReader = new BufferedReader(reader);
			
			while (true) {
				String linedata = bReader.readLine();// 한줄씩 읽어온다.
				if (linedata == null) {
					break; // 반복문 탈출
				} else {
					System.out.println(linedata);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "파일 예외");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "읽기 예외");
		} finally {
			try {
				bReader.close();
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
