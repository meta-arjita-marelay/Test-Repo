package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Copyright (c) 2018 Metacube.com. All rights reserved.
 * This is the main class.
 * @author Arjita
 *
 */
public class MainApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();
	}
	
}