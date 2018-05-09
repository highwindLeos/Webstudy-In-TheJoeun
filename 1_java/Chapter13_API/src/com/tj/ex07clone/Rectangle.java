package com.tj.ex07clone;
// 가로 세로(데이터) / 
// 생성자
// toString(), equals(), clone(), getArea() 
// setter getter
public class Rectangle implements Cloneable { // clone() 을 오버라이드 하려면 Cloneable 을 구현해야한다.
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
		resulte = "가로길이 : "+ width + "\t 세로길이 : " + height + "\t 넓이 : " + getArea();
				
		return resulte;
	}
	
	@Override
	public boolean equals(Object obj) { // r1.equals(r2) r1은 this r2는 obj
		if(obj != null && obj instanceof Rectangle) {
			boolean w = (width == ((Rectangle)obj).width);
			boolean h = (height == ((Rectangle)obj).height);
			
			return w && h; // 두개의 값을 전부 반환. 
		}else {
			return false;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	
}
	
