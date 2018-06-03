package com.lastcompany.haiwaicang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//
//@SpringBootApplication
//public class DemoApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//
//
////		SpringApplication app =
////				new SpringApplication(DemoApplication.class);
////
////		Properties properties = new Properties();
////		properties.setProperty("spring.resources.static-locations",
////				"classpath:/newLocation1/, classpath:/newLocation2/");
////		app.setDefaultProperties(properties);
////		app.run(args);
//	}
//}


@SpringBootApplication
// mapper 接口类扫描包配置
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws IOException {
		// 程序启动入口
		Properties properties = new Properties();
		InputStream in = DemoApplication.class.getClassLoader().getResourceAsStream("app.properties");
		properties.load(in);
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setDefaultProperties(properties);
		app.run(args);
		/*EmbeddedServletContainerAutoConfiguration*/

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		builder.sources(this.getClass());
		return super.configure(builder);


	}
}