package com.tj.ex083dpoint;

import com.tj.ex07clone.Rectangle;

public class Point3D implements Cloneable { //clone() �� �������̵��Ϸ��� Cloneable interface �� �����ؾ��Ѵ�.
	private int x;
	private int y;
	private int z;

	public Point3D() { }

	public Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// �޼ҵ�
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Point3D) { // ��ü���� ������ �׸��� ���� �ִٸ� ��
		// �Ű������� �Ѿ�� ��ü���� x ���� �� Ŭ������ ���� x�� ���ؼ� ������ ���� boolean ������ �����ϰ� ��ȯ
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
		resulte = "[" + x + "��," + y + "��," + z + "��]";

		return resulte;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
