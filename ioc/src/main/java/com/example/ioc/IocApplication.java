package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocApplication {

	public static void main(String[] args) {
		SpringApplication.run(IocApplication.class, args);
		ApplicationContext context = ApplicationContextProvider.getContext();

		// Get Component Classes
		// it's like GameObject Pattern of Unreal Engine
		// Component Annotation =  Using Singleton Pattern
		//Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
		// Encoder encoder = new Encoder(base64Encoder);

		Encoder encoder = context.getBean("Base64Encoder", Encoder.class);
		String url = "https://book.naver.com/bookdb/book_detail.naver?bid=21393791";

		String result = encoder.encode(url);
		System.out.println(result);
	}

}
