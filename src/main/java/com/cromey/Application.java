package com.cromey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the entry point of our application
 */
@SpringBootApplication
public class Application {
	
	public static void main (String... opts) {
    	SpringApplication.run(Application.class, opts);
    }

}