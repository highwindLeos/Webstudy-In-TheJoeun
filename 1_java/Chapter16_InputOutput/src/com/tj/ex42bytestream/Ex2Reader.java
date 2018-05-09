package com.tj.ex42bytestream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// 1 파일을 연다 (스트림 객체를 생성) 1 읽는다. 3 파일을 닫는다.(스트림 객체.close())
public class Ex2Reader {

	public static void main(String[] args) {
		Reader reader = null; // 파일을 여는 객체 변수 할당.
		try {
			reader = new FileReader("files/inTest.txt");
			char[] bs = new char[5]; // count 에는 몇 char 들어왔는지 확인
			while (true) {
				int count = reader.read(bs); // 2바이트 씩 가져온다. 가져올게 없다면 -1을 리턴.
				if (count == -1) {
					break;
				} else {
					System.out.print(bs); //  반환이 int 이기 때문임.
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try catch finally
	}
}
