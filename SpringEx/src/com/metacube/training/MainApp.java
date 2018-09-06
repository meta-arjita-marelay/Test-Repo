package com.metacube.training;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainApp {
	public static void main(String[] args) {
		BeanFactory applicationContext = new XmlBeanFactory(new FileSystemResource("Beans.xml"));
		TextEditor textEditor = (TextEditor) applicationContext.getBean("texteditor");
	}
}
