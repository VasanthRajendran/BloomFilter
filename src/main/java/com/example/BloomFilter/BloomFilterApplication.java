package com.example.BloomFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.BloomFilter")
public class BloomFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloomFilterApplication.class, args);
	}

}
