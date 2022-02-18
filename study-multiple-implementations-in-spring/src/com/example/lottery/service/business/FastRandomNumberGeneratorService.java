package com.example.lottery.service.business;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGeneratorService;

@Service
public class FastRandomNumberGeneratorService implements RandomNumberGeneratorService {

	@Override
	public int generate(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

}
