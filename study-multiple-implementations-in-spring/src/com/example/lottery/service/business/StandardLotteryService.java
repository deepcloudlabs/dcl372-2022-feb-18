package com.example.lottery.service.business;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.RandomNumberGeneratorService;
import com.example.lottery.service.RandomNumberServiceQuality;
import com.example.lottery.service.ServiceQualityLevel;

@Service
@SuppressWarnings("unused")
public class StandardLotteryService implements LotteryService {
	
	private Map<String,RandomNumberGeneratorService> 
   	         randomNumberGeneratorServicesMap;
	private List<RandomNumberGeneratorService> 
	                          randomNumberGeneratorServices;
	private AtomicInteger counter = new AtomicInteger();
	
	public StandardLotteryService(
			//@RandomNumberServiceQuality(ServiceQualityLevel.FAST)
	List<RandomNumberGeneratorService> randomNumberGeneratorServices,
	@Qualifier("fastRandomService")	
	@RandomNumberServiceQuality(ServiceQualityLevel.SECURE)
	Map<String,RandomNumberGeneratorService> randomNumberGeneratorServicesMap) {
	    this.randomNumberGeneratorServices = randomNumberGeneratorServices;
	    this.randomNumberGeneratorServicesMap = randomNumberGeneratorServicesMap;
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
