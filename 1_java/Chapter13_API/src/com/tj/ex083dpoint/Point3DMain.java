package com.tj.ex083dpoint;

public class Point3DMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D point1 = new Point3D(3, 3, 3);
		Point3D point2 = (Point3D) point1.clone();
		Point3D point3 = new Point3D(3, 4, 5);

		System.out.println(point1);
		System.out.println(point2);
		System.out.println(point3);

		String str = (point1.equals(point2)) ? "point1 과 point2 는 같다" : "point1 과 point2 는 다르다.";
		System.out.println(str);
	}

}
