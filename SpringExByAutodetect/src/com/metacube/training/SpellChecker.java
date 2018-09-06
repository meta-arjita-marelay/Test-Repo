package com.metacube.training;

/**
 * Copyright (c) 2018 Metacube.com. All rights reserved.
 * This is the Spell Checker class.
 * @author Arjita
 *
 */
public class SpellChecker {

	private boolean status;
	
	public SpellChecker(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status){
		this.status = status;
	}
	
	public void checkStatus() {
		if(getStatus())
		{
			System.out.println("Spelling check is on");
		}
		else{
			System.out.println("Spelling check is off");
		}
	}	
}
