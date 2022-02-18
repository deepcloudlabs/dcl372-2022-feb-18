package com.example.lottery.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGeneratorService;
import com.example.lottery.service.RandomNumberServiceQuality;
import com.example.lottery.service.ServiceQualityLevel;

@Service("fastRandomService")
@RandomNumberServiceQuality(ServiceQualityLevel.FAST)
public class FastRandomNumberGeneratorService implements RandomNumberGeneratorService {

	@Override
	public int generate(int min, int max) {
		System.err.println("FastRandomNumberGeneratorService::generate");
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
