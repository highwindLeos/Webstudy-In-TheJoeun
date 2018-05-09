package com.tj.ex4iterrator;

public class Person {
	private String name;
	private String tel;
	private String add;
	
	public Person() {}

	public Person(String name, String tel, String add) {
		this.name = name;
		this.tel = tel;
		this.add = add;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", tel=" + tel + ", add=" + add + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

}
