package com.tj.ex3file;

import java.io.File;

public class Ex2File {
	public static void main(String[] args) {
		File dir = new File("."); // 현제 디렉토리.
		String[] dirlist = dir.list(); // 파일의 목록을 모두 가져와 배열에 담는다.
		
//		for (String dt : dirlist) {
//			System.out.println(dt);
//		}
		
		File[] files = dir.listFiles(); // 파일과 디렉토리의 목록을 반환해서 File 배열에 넣는다.
		System.out.println("파일명\t\t 성격 \t 길이");
		for (int i = 0; i< files.length; i++) {
			
			if(files[i].getName().length() >= 7) { // 이름의 길이가 7자 이상이라면 true
				System.out.print(files[i].getName() +"\t"); // 이름을 가져온다.
			} else {
				System.out.print(files[i].getName() +"\t\t"); // 이름을 가져온다.
			}
//			System.out.print(files[i].isDirectory() ? "폴더" : "파일"); // 폴더인지 확인한다.
			
			if (files[i].isDirectory()) { // 폴더인지 확인한다.
				System.out.print("폴더 \t");
			} else {
				System.out.print("파일 \t");
			}
			System.out.println(files[i].length());//길이를 출력
		}
	}
}
