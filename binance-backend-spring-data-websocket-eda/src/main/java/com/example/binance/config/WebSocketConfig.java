package com.example.binance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.binance.service.MarketWebSocketService;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	private MarketWebSocketService marketWebSocketService;
	
	public WebSocketConfig(MarketWebSocketService marketWebSocketService) {
		this.marketWebSocketService = marketWebSocketService;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(marketWebSocketService,"/changes")
		        .setAllowedOrigins("*");
	}

}
