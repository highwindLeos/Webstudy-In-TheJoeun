package com.tj.ex3file;

import java.io.File;

public class Ex1File {

	public static void main(String[] args) {
		String path = "files/intest.txt";
		File file = new File(path); 
		
		if (file.exists()) { // 파일이 존재하는지 여부를 검증 존재하면 true
			System.out.println("존재하는 파일이라 지울께요.");
			file.delete(); // 파일을 삭제한다.
			System.out.println("파일 지워졌다.");
		} else {
			System.out.println("존재하지 않는 파일 입니다.");
		}
	}

}
