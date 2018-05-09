package com.tj.method;

public class Method01 {
	public static void main(String[] args) {
		printCh('★',45);
		System.out.println("Hellow Java");
		printCh();
		System.out.println("Hellow Java");
		printCh(15);
		System.out.println("Hellow Java");
		printCh('■');
	}
//	private static int printCh(char ch, int size) { 
//		
//	} 
	// 메소드의 다형성은 매개변수로 구분된다. (return type 로는 구분 불가)
	private static void printCh(char ch, int size) { // 매개 변수가 두개 있음. 리턴값 없음.
		for (int i =0; i < size; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
	
	private static void printCh() { // 매개변수 없음. return 값 없음.
		System.out.println("---------------------------------------------");
	} 
	
	private static void printCh(char ch) { // 매개변수 1개 있음. return 값 없음.
		for (int i = 0; i< 45 ; i++) { System.out.print(ch); }
		System.out.println();
	} 
	private static void printCh(int size) {
		for (int i = 0; i <size; i++) {
			System.out.print("-0-");
		}
		System.out.println();
	}
	// 위의 메소드들은 overloading 되었다 (다형성) = 같은 이름의 함수이나 다르게 동작한다.
}
