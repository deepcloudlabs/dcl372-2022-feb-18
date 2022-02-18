package com.example.lottery.service.business;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGeneratorService;

@Service
public class SecureRandomNumberGeneratorService implements RandomNumberGeneratorService {

	private SecureRandom secureRandom = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		return secureRandom .nextInt(min,max);
	}

}
