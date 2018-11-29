package com.rau.draw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("App main starting");
		Shape shape;

		// Using bean factory, for this spring.xml should be at root level(i.e.
		// pom.xml level) and dependency <artifactId>spring-beans</artifactId>
		// should be in pom.xml
		// BeanFactory bf = new XmlBeanFactory(new
		// FileSystemResource("spring.xml"));
		// shape = (Shape) bf.getBean("triangle");

		// Using ApplicationContext, for this spring.xml should be at class
		// level(i.e. inside \src\main\resources) and dependency
		// <artifactId>spring-context</artifactId> should be in pom.xml
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		shape = (Shape) context.getBean("triangle");

		shape.draw();
		System.out.println("---------------");
		System.out.println("App main ending");
	}
}
