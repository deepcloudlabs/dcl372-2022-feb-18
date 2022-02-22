package com.example.binance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.binance.event.TradeEvent;

public interface TradeEventRepository extends JpaRepository<TradeEvent, Long>{

}
