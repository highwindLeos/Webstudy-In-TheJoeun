package com.tj.ex06equals;

public class PersonMain {
	public static void main(String[] args) {
		
		Person person1 = new Person("920112-2", "홍길동");
		Person person2 = new Person("920112-2", "홍길동");
		Person person3 = new Person("930112-1", "홍길동");
		Person person4 = new Person("930112-1", "김마동");
		
		System.out.println("p1 의 해쉬코드 : " + person1.hashCode());  // 해쉬 코드를 반환.
		System.out.println("p2 의 해쉬코드 : " + person2.hashCode());
		
		if(person1.equals(person2)) { // 다른 객체이기 때문에 다른 사람 그러나 재정의한 equals() 로 확인한다.
			System.out.println("p1 이랑 p2 는 같은사람");
		} else {
			System.out.println("p1 이랑 p2 는 다른사람");
		}	
		
		if(person1.equals(person3)) { // 다른 객체이기 때문에 다른 사람 그러나 재정의한 equals() 로 확인한다.
			System.out.println("p1 이랑 p2 는 같은사람");
		} else {
			System.out.println("p1 이랑 p2 는 다른사람");
		}	
		
		if(person3.equals(person4)) { // 다른 객체이기 때문에 다른 사람 그러나 재정의한 equals() 로 확인한다.
			System.out.println("p3 이랑 p4 는 같은사람");
		} else {
			System.out.println("p3 이랑 p4 는 다른사람");
		}	
		
	}

}
