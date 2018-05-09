package com.tj.ex07clone;
// ���� ����(������) / 
// ������
// toString(), equals(), clone(), getArea() 
// setter getter
public class Rectangle implements Cloneable { // clone() �� �������̵� �Ϸ��� Cloneable �� �����ؾ��Ѵ�.
	private int width;
	private int height;
	
	public Rectangle() {}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	private int getArea() {
		return width * height;
	}
	
	@Override
	public String toString() {
		String resulte;
		resulte = "���α��� : "+ width + "\t ���α��� : " + height + "\t ���� : " + getArea();
				
		return resulte;
	}
	
	@Override
	public boolean equals(Object obj) { // r1.equals(r2) r1�� this r2�� obj
		if(obj != null && obj instanceof Rectangle) {
			boolean w = (width == ((Rectangle)obj).width);
			boolean h = (height == ((Rectangle)obj).height);
			
			return w && h; // �ΰ��� ���� ���� ��ȯ. 
		}else {
			return false;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
}
	
