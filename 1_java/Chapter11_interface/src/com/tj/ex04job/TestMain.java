package com.tj.ex04job;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		
		park.canCatchCriminal();
		park.canSerach();
		
		park.outFire();
		park.saveMan();
		
		park.makePizza();
		park.makeSpaghetti();
		
		System.out.println("* * * �ں����� ������ ��Ȱ * * *");
		PoliceMan parkPol = new Actor("�ں���");
		
		parkPol.canCatchCriminal(); parkPol.canSerach();
		/*parkPol.outFire(); parkPol.saveMan(); //������ Ÿ�Զ����� �޼ҵ� ȣ�� �Ұ� 
		parkPol.makePizza(); parkPol.makeSpaghetti(); //������ Ÿ�Զ����� �޼ҵ� ȣ�� �Ұ� */
		
		System.out.println("* * * �������� �ҹ�� ��Ȱ * * *");
		FireFighter chaFire = new Actor("������");
		
		/*parkPol.canCatchCriminal(); parkPol.canSerach(); //������ Ÿ�Զ����� �޼ҵ� ȣ�� �Ұ�*/
		chaFire.outFire(); chaFire.saveMan();
		/*parkPol.makePizza(); parkPol.makeSpaghetti(); //������ Ÿ�Զ����� �޼ҵ� ȣ�� �Ұ�*/
		
		System.out.println("* * * �ں����� �丮�� ��Ȱ * * *");
		Chef parkChef = new Actor("�ں���");
		
		/*parkChef.canCatchCriminal(); parkChef.canSerach(); //������ Ÿ�Զ����� �޼ҵ� ȣ�� �Ұ�*/
		/*parkChef.outFire(); parkChef.saveMan(); //������ Ÿ�Զ����� �޼ҵ� ȣ�� �Ұ� */
		parkChef.makePizza(); parkChef.makeSpaghetti(); 
		
	}

}
