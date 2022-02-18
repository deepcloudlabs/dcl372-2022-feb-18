package com.example.lottery.service.business;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.example.lottery.service.RandomNumberGeneratorService;
import com.example.lottery.service.RandomNumberServiceQuality;
import com.example.lottery.service.ServiceQualityLevel;

@Service
@RandomNumberServiceQuality(ServiceQualityLevel.SECURE)
public class SecureRandomNumberGeneratorService implements RandomNumberGeneratorService {

	private SecureRandom secureRandom = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomNumberGeneratorService::generate");
		return secureRandom .nextInt(min,max);
	}

}
