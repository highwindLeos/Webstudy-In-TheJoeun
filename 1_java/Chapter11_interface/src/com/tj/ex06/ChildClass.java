package com.tj.ex06;
//i1���, i2���, i3���, i11���, m1(), m2(), m3(), m11()
// int i11 = 11
// void m11()
public class ChildClass extends TestSuperClass implements I11{

	@Override
	public void m11() {
		System.out.println("i11 ��� : "+i11);
	}

}
