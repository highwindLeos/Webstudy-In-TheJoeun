package com.tj.ex1bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
// 1 InputStream(image.jpg) , OutPutStream (image_copy.jpg) 객체 생성
// 2. inputStream으로 read 해서 temp 변수에 넣어 temp 변수 내용을 outputStream 으로 write
// 위  2번 과정을 temp 가 -1 이 될때까지 계속
// 3. inputStream 객체도 outputSteam 객체도 close() 한다.
public class FileCopyStep2 {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image.jpg");
			out = new FileOutputStream(
					"C:/Users/Leodays/Desktop/Dev/webstudy/1_java/Chapter16_InputOutput/image_copy2.jpg");
			int i = 0;
			byte[] btemp = new byte[1024]; // 파일을 읽어 들일때 byte 단위로 끊어 온다. 
			while (true) {
				int count = in.read(btemp); // 반환이  int 이기 때문에 temp는 int 로 받는다. 가져올것이 없을때 -1 을 반환.
				i++;
				if (count == -1) { break; }
				else {
					out.write(btemp, 0, count); // write( 데이터배열, 시작점, 데이터 끝까지);
				}
			}
			System.out.println("반복문의 횟수는 : " + i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(out != null) { out.close(); }
				if(in != null) { in.close(); }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
				
	}

}
