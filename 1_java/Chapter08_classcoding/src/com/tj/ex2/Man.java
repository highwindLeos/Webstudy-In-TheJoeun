package com.tj.ex2;
// ���� Ű ������ ��ȭ��ȣ (������=�Ӽ�=�ʵ�),BMI ���� ��� (�޼ҵ�)
// Man m1 = new Man(); �� �ȵ�. (�ٸ� �����ڰ� �ִٸ� ������ ����)
public class Man {
	private int age; //����
	private int height; // Ű
	private int weight; // ������
	private String phonenumber; // ����
	
	public Man() { } // �⺻ ������. (�Ű����� ���� ������)
	
	public Man(int age, int height, int weight,String phonenumber) {
		System.out.println("�Ű������� 4���� ������.");
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phonenumber = phonenumber;
	}
	
	public Man(int height, int weight) {
		System.out.println("�Ű������� 2���� ������.");
		this.height = height;
		this.weight = weight;
	}
	
	// BMI ���� ���� : 60 / (1.7*1.7)
	public double calcluateBMI() {
		double resulte = weight / ((height*0.01) * (height*0.01));
		return resulte;
	}
	
	// setter and getter
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	
}
