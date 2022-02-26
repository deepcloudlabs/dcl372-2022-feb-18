package com.example.lottery.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumber;

@Component
public class LotteryPostProcessor implements BeanPostProcessor {
	@Autowired 
	private LotteryService lotteryService;
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.err.println("Before intialization: " + bean.getClass().getName());
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.err.println("After intialization: " + bean.getClass().getName());
		var clazz = bean.getClass();
		for(var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var randomNumber = field.getAnnotation(RandomNumber.class);
				try {
					field.setAccessible(true);
					field.set(bean, lotteryService.draw(randomNumber.max(), randomNumber.size()).get());
					field.setAccessible(false);
				} catch (Exception e) {
				}
			}
		}
		return bean;
	}

}
