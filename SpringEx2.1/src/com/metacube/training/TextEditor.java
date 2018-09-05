package com.metacube.training;

/**
 * Copyright (c) 2018 Metacube.com. All rights reserved.
 * This is the Text Editor class.
 * @author Arjita
 *
 */
public class TextEditor {

	private SpellChecker spellChecker;

	// a setter method to return spellChecker
	public void setSpellChecker(SpellChecker spellChecker) {
			this.spellChecker = spellChecker;
		}

	// a getter method to return spellChecker
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkStatus();
	}
}
