package com.tj.ex083dpoint;

import com.tj.ex07clone.Rectangle;

public class Point3D implements Cloneable { //clone() 를 오버라이드하려면 Cloneable interface 를 구현해야한다.
	private int x;
	private int y;
	private int z;

	public Point3D() { }

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// 메소드
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Point3D) { // 객체형이 같은지 그리고 값이 있다면 참
		// 매개변수로 넘어온 객체안의 x 값과 이 클래스의 변수 x와 비교해서 맞으면 참을 boolean 변수에 대입하고 반환
			boolean bx = (x == ((Point3D) obj).x); 
			boolean by = (y == ((Point3D) obj).y);
			boolean bz = (z == ((Point3D) obj).z);

			return bx && by && bz;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String resulte;
		resulte = "[" + x + "값," + y + "값," + z + "값]";

		return resulte;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
