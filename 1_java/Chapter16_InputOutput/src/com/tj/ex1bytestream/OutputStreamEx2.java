package com.tj.ex1bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1. 파일을 연다.(스트림 객체 생성) 2. Write 한다. 3. 파일을 닫는다.(스트림 객체를 제거한다. close)
public class OutputStreamEx2 {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			// 두번째 인자값으로 true 를 주면 '추가' 기능으로 작동한다. 파일을 덮어쓰지 않고 내용을 추가한다. 기본은 false.
			os = new FileOutputStream( 
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/outTest.txt", true);
			String temp = "\n안녕하세요\r\n어서오세요"; // 파일에 쓸 문자열을 만든다.
			byte[] bs = temp.getBytes(); // 문자열을 byte 로 바꾸어 줍니다.

//			for (int i = 0; i < bs.length; i++) {
//				os.write(bs[i]); // 1byte 씩 파일에 쓴다. 한글도 자기가 알아서 한다
//			}
			
			os.write(bs); // 알아서 1byte 씩 써서 작업을 완료한다.

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "파일을 만들수 없습니다");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "파일을 쓸 수 없습니다");
		} finally {
			// 파일을 닫는다.
			try {
				if(os != null) { os.close(); } // FileOutputStream 를 닫는다.
			} catch (IOException e) {
				System.out.println(e.getMessage() + "쓰다가 예외 발생");
			}
			
		}
		System.out.println();
		System.out.println("프로그램 종료");
	}
}
