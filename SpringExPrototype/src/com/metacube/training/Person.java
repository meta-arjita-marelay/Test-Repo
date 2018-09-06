package com.metacube.training;

public class Person {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void showName(){
		System.out.println("Your Name : " + getName());
	}
}
