package com.example.lottery.service.business;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGeneratorService;

@Service
public class StandardLotteryService implements LotteryService {

	private List<RandomNumberGeneratorService> 
	                          randomNumberGeneratorServices;
	private AtomicInteger counter = new AtomicInteger();
	
	public StandardLotteryService(
			//@RandomNumberServiceQuality(ServiceQualityLevel.FAST)
	List<RandomNumberGeneratorService> randomNumberGeneratorServices) {
	    this.randomNumberGeneratorServices = randomNumberGeneratorServices;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		var index = counter.getAndIncrement() % 
				randomNumberGeneratorServices.size();
		var randomNumberGeneratorService = 
				randomNumberGeneratorServices.get(index);
		return IntStream.generate(() -> 
		       randomNumberGeneratorService.generate(1, max))
				        .distinct()
				        .limit(size)
				        .sorted()
				        .boxed()
				        .toList();
	}

}
