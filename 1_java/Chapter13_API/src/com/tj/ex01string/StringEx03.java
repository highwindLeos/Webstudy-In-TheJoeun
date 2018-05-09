package com.tj.ex01string;

public class StringEx03 {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = " 이것이 자바다 ";
		
		System.out.println(str3.trim()); // 앞뒤의 공백을 제거한다. 문자열 중간의 공백은 그대로 둔다.
		System.out.println(str1.replace('a', 'Z')); // 첫번째 매개값을 두번째 매개값으로 바꾼다. : ZbcXZbc
		System.out.println(str1.replaceAll("a", "안녕")); // 첫번째 매개값을 두번째 매개값으로 바꾼다. : 안녕bcX안녕bc
		System.out.println(str1.replaceFirst("a", "안녕")); // 처음으로 매치되는 첫번째 매개값을 두번째 매개값으로 바꾼다. : 안녕bcXabc
		
		System.out.println(str1.concat(str2)); // concat(); 문자열을 붙여서 출력. abcXabcabcXabc
		System.out.println(str1.substring(3)); // 입력한 정수값의 3 이후로 문자열의 끝까지 출력함.
		System.out.println(str1.substring(3, 6)); // 입력한 정수값의 3 이후로 문자열의 index 6 까지 출력함.
		System.out.println(str1.length()); // 문자수를 반환. (index의 길이를 반환) : 7
		System.out.println(str1.toUpperCase()); // 문자 case 를 대문자로 바꿈
		System.out.println(str1.toLowerCase()); // 문자 case 를 소문자로 바꿈
		System.out.println(str1.charAt(3)); // 입력한 값의 index 의 문자를 반환함. : X
		System.out.println(str1.equals(str2)); // 문자열의 값을 비교한다. (객체형 변수비교) : true
		System.out.println(str1.equalsIgnoreCase(str2)); // 문자의 case 를 무시하고 값을 비교 해서 같으면 true
		System.out.println(str1.indexOf("X")); // 해당 입력 문자가 몇번 인덱스 인지 반환 : 3 해당 문자가 없으면 -1 값을 반환.
		
		String str4 = "꽃나무는 꽃나무 꽃을 피워 꽃나무";
		System.out.println(str4.indexOf("꽃")); // 처음으로 같은 값을 반환. 뒤에 몇개 같은 값이 있는지는 확인 안한다. : 0
		System.out.println(str4.indexOf("꽃", 3)); // 인덱스 3번부터 찾아서 값을 반환. (2번째 인자값은 정수) : 5
		System.out.println(str4.lastIndexOf("꽃")); // 뒤에서 부터 찾아서 같은 값의 인덱스를 반환 : 15
		System.out.println(str4.lastIndexOf("꽃", 8)); // 뒤에서 8번째부터 찾아서 같은 값이면 인덱스를 반환 : 5
		
		System.out.println();
		// 응용 문제 2개.
		StringEx01 ex01 = new StringEx01();
		//com.tj.ex01string.StringEx01
		System.out.println(ex01.getClass().getName()); // 클래스이름을 반환 (패키지 명까지)
		// StringEx01 을 반환하게 하라.
		String stemp = ex01.getClass().getName();
		int idx = stemp.lastIndexOf('.'); // 마지막 . 의 인덱스 를 가져온다.
		System.out.println(stemp.substring(idx+1)); // 해당문자열의   . + 1 번째 부터 출력
		
		idx = stemp.indexOf('.'); // 첫 . 이 있는 인덱스를 반환
		System.out.println(stemp.substring(0, idx)); // com 을 출력 0부터 3인덱스까지의 문자열을 출력
	}//main()

}
