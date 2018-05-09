package com.tj.ex3file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex3File {

	public static void main(String[] args) throws IOException {
		File file = new File("files/inTest.txt");
		if (file.exists()) {
			// 존재하는 파일이면 절대경로 표준경로 생성일 파일크기 파일속성
			System.out.println("절대경로 : " + file.getAbsolutePath()); // 절대 경로를 반환.
			System.out.println("상대경로 : " + file.getCanonicalPath()); // 상대경로를 반환.
			Date time = new Date(file.lastModified()); // 파일이 마지막으로 수정된 시간을 반환.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a hh시 mm분 ss초");

			System.out.println("생성일 : " + sdf.format(time));
			// 첫번째 변수에서 모든 옵션을 참조한다( %1$ )
			System.out.printf("%1$tY년 %1$tm월 %1$td일 (%1$ta) %1$tp %1$tH시 %1$tM분 %1$tS초 ", time);

			System.out.println("파일의 크기 : " + file.length());
			System.out.println("읽기 속성 : " + file.canRead());
			System.out.println("쓰기 속성 : " + file.canWrite());
			System.out.println("쓰기 속성 : " + file.isHidden());

		} else {
			System.out.println("존재하지 않는 파일입니다.");
		}
	}

}
