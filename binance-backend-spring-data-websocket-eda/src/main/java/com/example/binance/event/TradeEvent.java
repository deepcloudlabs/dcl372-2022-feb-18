package com.example.binance.event;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "trades")
public class TradeEvent {
	@Id
	@JsonProperty("t")
	private long sequenceId;
	@JsonProperty("s")
	private String Symbol;
	@JsonProperty("p")
	private String price;
	@JsonProperty("q")
	private String quantity;
	@JsonProperty("T")
	private long timestamp;
	@JsonProperty("b")
	private long bid;
	@JsonProperty("a")
	private long ask;

	public TradeEvent() {
	}

	public long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(long sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public long getAsk() {
		return ask;
	}

	public void setAsk(long ask) {
		this.ask = ask;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sequenceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TradeEvent other = (TradeEvent) obj;
		return sequenceId == other.sequenceId;
	}

	@Override
	public String toString() {
		return "TradeEvent [sequenceId=" + sequenceId + ", Symbol=" + Symbol + ", price=" + price + ", quantity="
				+ quantity + ", timestamp=" + timestamp + ", bid=" + bid + ", ask=" + ask + "]";
	}

}
