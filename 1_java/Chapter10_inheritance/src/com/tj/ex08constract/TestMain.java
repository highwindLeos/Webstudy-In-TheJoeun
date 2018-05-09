package com.tj.ex08constract;

public class TestMain {

	public static void main(String[] args) {
		
		Person papa = new Person("¾Æºü°õ","¶×¶×ÇØ");
		papa.intro();
		
		Person mam = new Person("¾ö¸¶°õ","³¯¾ÀÇØ");
		mam.intro();
		
		Baby child1 = new Baby("¾Æ±â°õ","³Ê¹« ±Í¿©¿ö");
		
		child1.intro();
		child1.cry();
		
	}

}
