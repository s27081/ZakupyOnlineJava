package com.example.ZakupyOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZakupyOnlineApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZakupyOnlineApplication.class, args);
	}

	ZakupyOnlineApplication(){
		init_process();
	}

	public void init_process(){
		System.out.println("Hello world");
	}
}
