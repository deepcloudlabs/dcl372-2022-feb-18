package com.example.lottery.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGeneratorService;

public class LotteryApp {
	private static final String BASE_PACKAGE = "com.example.lottery";

	public static void main(String[] args) {
		var container = 
			new AnnotationConfigApplicationContext(BASE_PACKAGE);
		container.getBean(LotteryService.class)
		         .draw(60, 6, 10)
		         .forEach(System.out::println);
		var randomSrv =
			container.getBean("fastRandomService", 
					RandomNumberGeneratorService.class);
		System.out.println(randomSrv.generate(100, 200));
		container.close();	
	}

}
