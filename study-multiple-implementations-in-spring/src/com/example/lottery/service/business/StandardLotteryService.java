package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGeneratorService;

@Service
public class StandardLotteryService implements LotteryService {

	private RandomNumberGeneratorService randomNumberGeneratorService;
	
	public StandardLotteryService(RandomNumberGeneratorService randomNumberGeneratorService) {
		this.randomNumberGeneratorService = randomNumberGeneratorService;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate(() -> 
		       randomNumberGeneratorService.generate(1, max))
				        .distinct()
				        .limit(size)
				        .sorted()
				        .boxed()
				        .toList();
	}

}
