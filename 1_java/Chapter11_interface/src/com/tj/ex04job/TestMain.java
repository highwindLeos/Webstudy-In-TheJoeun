package com.tj.ex04job;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		
		park.canCatchCriminal();
		park.canSerach();
		
		park.outFire();
		park.saveMan();
		
		park.makePizza();
		park.makeSpaghetti();
		
		System.out.println("* * * 박보검이 경찰관 역활 * * *");
		PoliceMan parkPol = new Actor("박보검");
		
		parkPol.canCatchCriminal(); parkPol.canSerach();
		/*parkPol.outFire(); parkPol.saveMan(); //변수의 타입때문에 메소드 호출 불가 
		parkPol.makePizza(); parkPol.makeSpaghetti(); //변수의 타입때문에 메소드 호출 불가 */
		
		System.out.println("* * * 차태현이 소방관 역활 * * *");
		FireFighter chaFire = new Actor("차태현");
		
		/*parkPol.canCatchCriminal(); parkPol.canSerach(); //변수의 타입때문에 메소드 호출 불가*/
		chaFire.outFire(); chaFire.saveMan();
		/*parkPol.makePizza(); parkPol.makeSpaghetti(); //변수의 타입때문에 메소드 호출 불가*/
		
		System.out.println("* * * 박보검이 요리사 역활 * * *");
		Chef parkChef = new Actor("박보검");
		
		/*parkChef.canCatchCriminal(); parkChef.canSerach(); //변수의 타입때문에 메소드 호출 불가*/
		/*parkChef.outFire(); parkChef.saveMan(); //변수의 타입때문에 메소드 호출 불가 */
		parkChef.makePizza(); parkChef.makeSpaghetti(); 
		
	}

}
