package com.example.picpay_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@SpringBootApplication
public class PicpayProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayProjectApplication.class, args);
	}


	public String toString() {
		return "abcde";
	}
}
