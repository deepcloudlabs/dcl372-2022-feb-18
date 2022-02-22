package com.example.binance.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.binance.event.TradeEvent;
import com.example.binance.repository.TradeEventRepository;

@Service
public class TradeEventService {

	private TradeEventRepository tradeEventRepository;
	
	
	public TradeEventService(TradeEventRepository tradeEventRepository) {
		this.tradeEventRepository = tradeEventRepository;
	}

	@EventListener
	public void listenTradeEvents(TradeEvent tradeEvent) {
		tradeEventRepository.save(tradeEvent);
	}
}
