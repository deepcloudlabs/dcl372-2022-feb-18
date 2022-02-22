package com.example.binance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
public class AppConfig {
	
	@Bean
	public WebSocketClient webSocketClient() {
		return new StandardWebSocketClient();
	}
}
