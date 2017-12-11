package com.hbsis.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	/*
	 * 3. override the method configure to deploy a war file
	 * 
	 * The SpringBootServeletInitializer taps into a Servlet 3 <br>
	 * Programmatically defines a description of web.xml file
	 */

	private static Class<BookStoreApplication> applicationClass = BookStoreApplication.class;

	//@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}

}
