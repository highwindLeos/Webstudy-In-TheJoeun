package com.tj.ex09scanner;

import java.util.Scanner;

public class ScannerEx1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이는 ?");
		// white space ('\n', ' ' '\t') 앞까지의 정수를 가져옴
		int age = scanner.nextInt();
		
		System.out.print("이름은 ?");
		// white space (엔터, ' ' '\t') 앞까지의 스트링을 가져옴
		String name = scanner.next();
		
		System.out.print("주소는 ?");
		// \n 이 버퍼에 남는 입력이라면 데이터를 입력할수 없다.
		scanner.nextLine(); // 버퍼를 지우는 용도
		String add = scanner.nextLine(); // nextLine(); 공백도 포함해서 입력받을 수 있다.
		System.out.println(name + " : " + age + "살에 주소는 " + add);
		System.out.println("끝");
		scanner.close();
	}

}
