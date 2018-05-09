package com.tj.ex09scanner;

import java.util.Scanner;

public class ScannerEx2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름은 ?");
		// white space ('\n', ' ' '\t') 앞까지의 정수를 가져옴
		String name = scanner.nextLine(); // nextLine(); 공백도 포함해서 입력받을 수 있다.
		
		System.out.print("주소는 ?");
		// white space (엔터, ' ' '\t') 앞까지의 스트링을 가져옴
		String add = scanner.nextLine(); // nextLine(); 공백도 포함해서 입력받을 수 있다.
		
		System.out.print("나이는 ?");
		scanner.nextLine(); // \n 이있는 버퍼 지우기
		
		//int age = Integer.parseInt(scanner.nextLine()); 이런 방법도 있다. 문자로 숫자를 받을 경우만 해당.
		int age = scanner.nextInt();
		
		System.out.println(name + " : " + age + "살에 주소는 " + add);
		System.out.println("끝");
		scanner.close();
	}

}
