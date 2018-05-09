package com.tj.ex42bytestream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex5Write {

	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("files/inout.txt", true); // 파일에 내용을  추가한다. 기본값은 false로 덮어씀.
			/*char[] arr = {'안','녕','하','세','요'};
			for (char ta : arr) {
				System.out.print(ta);
			}*/
			String str = "안녕하세요\r\n자바";
			writer.write(str);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				writer.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
