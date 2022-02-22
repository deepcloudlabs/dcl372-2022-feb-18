package com.example.binance.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.example.binance.event.TradeEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MarketWebSocketService implements WebSocketHandler {
	private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
	@Autowired
	private ObjectMapper objectMapper;

	@EventListener
	public void listenTradeEvents(TradeEvent event) {
		synchronized (sessions) {
			sessions.forEach((sessionId, session) -> {
				try {
					var json = objectMapper.writeValueAsString(event);
					var message = new TextMessage(json);
					session.sendMessage(message);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			});
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.put(session.getId(), session);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable e) throws Exception {
		System.err.println("Error in websocket server: " + e.getMessage());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		sessions.remove(session.getId());
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
}
