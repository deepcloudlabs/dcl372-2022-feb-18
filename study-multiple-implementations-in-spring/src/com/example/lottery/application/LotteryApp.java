package com.example.lottery.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lottery.service.LotteryService;

public class LotteryApp {
	private static final String BASE_PACKAGE = "com.example.lottery";

	public static void main(String[] args) {
		var container = 
			new AnnotationConfigApplicationContext(BASE_PACKAGE);
		container.getBean(LotteryService.class)
		         .draw(60, 6, 10)
		         .forEach(System.out::println);
		container.close();	
	}

}
