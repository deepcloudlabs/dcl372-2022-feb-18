package com.example.lottery.service;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

//@Service
//@Repository
//@Component
@Named // CDI
@Singleton
public class LotteryService {
	
	@Async
	public Future<List<Integer>> draw(int max, int size){
			var lotteryNumbers = 
					ThreadLocalRandom.current()
					.ints(1, max)
					.distinct()
					.limit(size)
					.sorted()
					.boxed()
					.toList();
			try { TimeUnit.MILLISECONDS.sleep(5); } catch (Exception e) { }
			// Java SE 7 : <> -> diamond operator
			// Smart Compiler
			return new AsyncResult<>(lotteryNumbers);			
	}
}
