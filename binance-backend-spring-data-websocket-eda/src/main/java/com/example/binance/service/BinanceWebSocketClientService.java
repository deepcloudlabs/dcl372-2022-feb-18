package com.example.binance.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import com.example.binance.event.TradeEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BinanceWebSocketClientService 
                                 implements WebSocketHandler {
	@Value("${binance.websocket.url}")
	private String binanceUrl;
	
	private WebSocketClient webSocketClient;
	private ObjectMapper objectMapper;
	private ApplicationEventPublisher eventPublisher;

	public BinanceWebSocketClientService(WebSocketClient webSocketClient, ObjectMapper objectMapper,
			ApplicationEventPublisher eventPublisher) {
		this.webSocketClient = webSocketClient;
		this.objectMapper = objectMapper;
		this.eventPublisher = eventPublisher;
	}

	@PostConstruct
	public void connect() {
		webSocketClient.doHandshake(this, binanceUrl);
	}
	
	@PreDestroy
	public void disconnect() {
		
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.err.println("Connected to the binance server!");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		var payload = message.getPayload().toString();
		var tradeEvent = objectMapper.readValue(
				payload,TradeEvent.class);
		eventPublisher.publishEvent(tradeEvent);
		System.err.println(tradeEvent);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable e) throws Exception {
		System.err.println("An error has occured: "+e.getMessage());		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		System.err.println("Disconnected!");
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
