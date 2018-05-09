package com.tj.ex04access;

public class Woman {
	
	public Woman() {
		privateMethod();
	}
	
	private void privateMethod() {System.out.println("private");}
	
	void defaultMethod() {System.out.println("default");}
	
	protected void protectedMethod() {System.out.println("protected");}
	
	public void publicMethod() {System.out.println("public");}
	
}
