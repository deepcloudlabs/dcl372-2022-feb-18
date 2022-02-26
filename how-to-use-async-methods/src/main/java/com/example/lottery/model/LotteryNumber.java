package com.example.lottery.model;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.service.RandomNumber;

@Component
@RequestScope
public class LotteryNumber {
	@RandomNumber(min = 1, max = 60, size = 6, distinct = true, sorted = true)
	private List<Integer> numbers;
	
	public LotteryNumber() {
		System.err.println("LotteryNumber::LotteryNumber");
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
