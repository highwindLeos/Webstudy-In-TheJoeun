package com.tj.ex42bytestream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex4KeyBoardFile {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader bReader = null;
		BufferedReader keyboard = null; // 키보드 입력을 위한 스트림.
				
		keyboard = new BufferedReader(new InputStreamReader(System.in)); //키보드로 한줄씩 입력받을수 있는 인풋스트림
		// 폴더 없이 파일만 입력시 ch17 root 폴더에 파일로 인식.
		System.out.print("원하는 파일은(폴더 포함)? "); 	
		try {
			String filename = keyboard.readLine();
			File file = new File(filename);
			if (file.exists()) { // 존재하는 파일의 경우 입력받아서 처리
				reader = new FileReader(file);
				bReader = new BufferedReader(reader);
				
				while (true) {
					String linedata = bReader.readLine();// 한줄씩 반환해서 문자열에 담음.
					if (linedata == null) {
						break;
					} else {
						System.out.println(linedata);
					}
				}
			} else {
				System.out.println("입력하신 파일이 존재하지 않습니다.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bReader.close();
				reader.close();
			} catch (IOException e) {
//				System.out.println(e.getMessage());
			}
		}// try catch finally
	} // main
}
