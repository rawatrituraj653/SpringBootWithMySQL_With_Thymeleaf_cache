package com.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootWithMySqlWithThymeleafCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMySqlWithThymeleafCacheApplication.class, args);
	}

}
