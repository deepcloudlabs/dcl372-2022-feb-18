package com.example.lottery;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.lottery.service.LotteryService;

// Spring Framework Core -> Components -> Class/OOP -> POJO
//                          Container/Application Server/App Server/IoC Container -> DI Framework
//                          AOP, DI, Component-Based Programming
//                          Component -> Annotation

//                          Spring Bean Definition:     
//                                       @Configuration: Bean Configuration
//										 @SpringBootApplication : Spring Boot App
//										 @Component, @Service, @Repository : Core Component
//                                       @Controller, @RestController: Spring MVC
//										 @Bean	
//                                       CDI: @Named, @Produces

//                           Spring Bean Scope:
//                           @Scope("request"), @Scope("session"), ...
//                           @RequestScope, @SessionScope, ... 
//                           CDI: @RequestScoped, @SessionScoped, ...

//                           Dependencies between Spring Beans
//                           @Autowired
//                           CDI: @Inject
//                           Life-Cycle Callback Annotations: 
//                              Common Annotations: @PostConstruct, @PreDestroy
//                              Jpa's Annotations : @PrePersist, @PreRemove, @PreUpdate
// 													@PostPersist, @PostRemove, @PostUpdate



/* Java DI Framework: i) Spring 
                     ii) Java EE 6 -> CDI 
                    iii) JBoss SEAM -> Delta Spike (ASF) -> CDI Extension
                     iv) Guice (Google) -> CDI 
*/
@SpringBootApplication
public class HowToUseAsyncMethodsApplication implements ApplicationRunner {
	@Value("${lottery-message}")
	private String message;
	
	@Inject
	private LotteryService lotteryService;
	
	public static void main(String[] args) {
		SpringApplication.run(HowToUseAsyncMethodsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.err.println(message);
		System.out.println(lotteryService.draw(60, 6).get()); 
	}

}
