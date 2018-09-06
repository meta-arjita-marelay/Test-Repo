package com.metacube.training;

public class SpellChecker {
	private boolean check;

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public void checker(){
		System.out.println("SpellChecker invoked!!!!");
		System.out.println(check);
	}
}
