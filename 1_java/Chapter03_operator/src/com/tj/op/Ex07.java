package com.tj.op;

// 할당 연산자 : 우선순위는 연산자 중에 가장 낮다.
public class Ex07 {

	public static void main(String[] args) {
		System.out.println("== 할당연산자 (대입) ==");
		
		int n1 = 10 * 3;
		System.out.println(n1);
		
		n1 += 10; // n1 = n1 + 10;
		System.out.println(n1);
		
		n1 -= 10; // n1 = n1 - 10;
		System.out.println(n1);
		
		n1 *= 10; // n1 = n1 * 10;
		System.out.println(n1);
		
		n1 /= 10; // n1 = n1 / 10;
		System.out.println(n1);
		
		n1 += 1; // ++n1; n1 = n1 + 1;
		System.out.println(n1);
		
		int n2;
		n2 = 100;
		System.out.println("n2 = " + n2); // n2 에 100 을 대입하는 것이 최우선.
		
		int n3, n4, n5;
		n3 = n4 = n5 = 100;
		System.out.println("n3 = "+ n3 +" n4 = "+ n4 +" n5 = "+ n5);
		
		}

}
