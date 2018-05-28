package com.lastcompany.haiwaicang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


//		SpringApplication app =
//				new SpringApplication(DemoApplication.class);
//
//		Properties properties = new Properties();
//		properties.setProperty("spring.resources.static-locations",
//				"classpath:/newLocation1/, classpath:/newLocation2/");
//		app.setDefaultProperties(properties);
//		app.run(args);
	}
}
