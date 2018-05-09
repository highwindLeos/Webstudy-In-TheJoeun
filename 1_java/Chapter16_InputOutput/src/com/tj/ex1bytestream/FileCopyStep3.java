package com.tj.ex1bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
// 1 InputStream(image.jpg) , OutPutStream (image_copy.jpg) 객체 생성
// 2. inputStream으로 read 해서 temp 변수에 넣어 temp 변수 내용을 outputStream 으로 write
// 위  2번 과정을 temp 가 -1 이 될때까지 계속
// 3. inputStream 객체도 outputSteam 객체도 close() 한다.
public class FileCopyStep3 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			File orignalFile = new File(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			in = new FileInputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			out = new FileOutputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image_copy3.jpg");
			// 읽어오는 파일을 File class 객체로 만들어야 해당 사이즈를 얻어오는 함수가 있다.
			// length() 반환값은 long 이다. 그래서 int 로  casting
			byte[] btemp = new byte[(int) orignalFile.length()]; // 파일을 읽어 들일때 byte 단위로 끊어 온다. 
			while (true) {
				int count = in.read(btemp); // 반환이  int 이기 때문에 temp는 int 로 받는다. 가져올것이 없을때 -1 을 반환.
				if (count == -1) { 
					break; 
				} else {
					out.write(btemp, 0, count); // write( 데이터배열, 시작점, 데이터 끝까지);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(out != null) { out.close(); } // in 열고 out 을 열었다면 닫는것은 out -> in 순서대로 닫아줌.
				if(in != null) { in.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
				
	}

}
