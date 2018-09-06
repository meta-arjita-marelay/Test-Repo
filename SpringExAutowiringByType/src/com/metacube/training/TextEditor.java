package com.metacube.training;

/**
 * Copyright (c) 2018 Metacube.com. All rights reserved.
 * This is the Text Editor class.
 * @author Arjita
 *
 */
public class TextEditor {

	private SpellChecker spellChecker;

	// a constructor method to inject the dependency.
	/*public TextEditor(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}*/
	
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	
	public void spellCheck() {
		spellChecker.checkStatus();
	}
}
