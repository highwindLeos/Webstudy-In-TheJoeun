package com.tj.ex02;

public class PointTest {

	public static void main(String[] args) {

		Point2D p1 = new Point2D();
		
		p1.setX(10); p1.setY(5);
		System.out.println("p1(x,y) ÁÂÇ¥ = (" + p1.getX() + " , " + p1.getY() + ")");

		Point3D p2 = new Point3D();

		p2.setX(10); p2.setY(5); p2.setZ(15);
		System.out.println("p2(x,y,z) ÁÂÇ¥ = (" + p2.getX() + " , " + p2.getY() + " , " + p2.getZ() + ")");

	}
}
