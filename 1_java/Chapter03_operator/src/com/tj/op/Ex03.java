package com.tj.op;

public class Ex03 {

	public static void main(String[] args) {
		System.out.println("== 관계 비교 연산자 (==, !=, >, >=, <, <=) ==");
		
		 int n1 = 10, n2 = 5;
		 boolean resulte;
		 
		 resulte = n1 > n2; // true
		 System.out.printf("%d %c %d = %b \n", n1, '>', n2, resulte);
		 
		 resulte = n1 < n2; // false
		 System.out.printf("%d %c %d = %b \n", n1, '<', n2, resulte);
		 
		 resulte = (n1 >= n2); // true
		 System.out.printf("%d %s %d = %b \n", n1, ">=", n2, resulte);
		 
		 resulte = (n1 <= n2); // false
		 System.out.printf("%d %s %d = %b \n", n1, "<=", n2, resulte);
		 
		 resulte = (n1 == n2); // false
		 System.out.printf("%d %s %d = %b \n", n1, "==", n2, resulte);
		 
		 resulte = (n1 != n2); // true
		 System.out.printf("%d %s %d = %b \n", n1, "!=", n2, resulte);
		 
	}

}
