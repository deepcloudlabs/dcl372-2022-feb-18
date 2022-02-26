package com.example.lottery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.lottery.model.LotteryNumber;

@RestController
@RequestScope
@RequestMapping("/numbers")
public class LotteryRestController {

	@Autowired
	private LotteryNumber lottery;
	
	@GetMapping
	public List<Integer> getLotteryNumbers(){
		return lottery.getNumbers();
	}
}
