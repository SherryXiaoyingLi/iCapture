package com.social.network.icapture;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class IcaptureApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcaptureApplication.class, args);
	}

	@Bean
	public Logger getLogger() {
		return LoggerFactory.getLogger("AppsDeveloperBlog");
	}

}
