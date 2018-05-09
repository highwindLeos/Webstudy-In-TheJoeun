package com.tj.ex08;

public class PersonMain {

	public static void main(String[] args) {
		
		System.out.println("comm_money " + Person.COMM_MONEY);
		
		Person p1 = new Person("Leoday");
		Person p2 = new Person("LeeDay");
		Person p3 = new Person("LeeManhwa");
		
		p1.saveMoney(1000);
		Person.COMM_MONEY += 1000;
		
		p1.currentMoney();
		
		p2.saveMoney(2000);
		Person.COMM_MONEY += 2000;
		
		p2.currentMoney();
		
		p3.saveMoney(3000);
		Person.COMM_MONEY -= 3000;
		
		p3.currentMoney();

	}

}
