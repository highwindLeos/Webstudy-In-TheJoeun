package com.tj.ex03Shape;

public class MainClass {

	public static void main(String[] args) {
		
//		Shape circle = new Circle(5);
//		Shape triangle = new Triangle(10,5);
//		Shape rectangle = new Reacangle(10,10);
		
		Shape[] shape = {
						new Circle(5), 
						new Triangle(10,5),
						new Reacangle(10,10)
						};
		
		for(Shape stemp : shape) {
			stemp.computerArea();
			stemp.draw();
		}

	}

}
