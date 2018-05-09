package com.tj.ex07;

public class TestMain {

	public static void main(String[] args) {
		Person papa = new Person();
		
		papa.setName("¾Æºü°õ");
		papa.setCharacter("¶×¶×ÇØ");
		papa.intro();
		
		Person mam = new Person();
		
		mam.setName("¾ö¸¶°õ");
		mam.setCharacter("³¯¾ÀÇØ");
		mam.intro();
		
		Baby child1 = new Baby();
		
		child1.setName("¾Æ±â°õ");
		child1.setCharacter("³Ê¹« ±Í¿©¿ö");
		child1.intro();
		child1.cry();
		
	}

}
