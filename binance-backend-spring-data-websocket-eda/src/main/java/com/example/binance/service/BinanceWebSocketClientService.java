package com.example.binance.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;

@Service
public class BinanceWebSocketClientService {

	private WebSocketClient webSocketClient;

	public BinanceWebSocketClientService(WebSocketClient webSocketClient) {
		this.webSocketClient = webSocketClient;
	}
	
	@PostConstruct
	public void connect() {
		webSocketClient.doHandshake(null, "");
	}
}
