package com.tj.ex07clone;

public class RectangleTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle rc1 = new Rectangle(8, 9);
		Rectangle rc2 = (Rectangle)rc1.clone(); // 복제 : 주소가 달라진 내용이 같은 객체를 만든다.
		Rectangle rc3 = rc1; // 객체를 담고 있는 주소도 같다.
		
		if (rc1 == rc3) {
			System.out.println("r3은 r1 복제한 게 아니네");
		}
		
		if (rc1 == rc2) {
			System.out.println("r2은 r1 복제한 게 아니네");
		} else {
			System.out.println("r2은 r1 주소가 다르네");
		}
		
		System.out.println("rc1 : "+ rc1); // 오버라이드 된 toString() 으로 출력됨.
		System.out.println("rc2 : "+ rc2);
		
		if(rc1.equals(rc2)) {
			System.out.println("같은 모양");
		} else {
			System.out.println("다른 모양");
		}
		
	}

}
