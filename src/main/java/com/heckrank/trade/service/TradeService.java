package com.heckrank.trade.service;

import java.util.List;

import com.heckrank.trade.model.Trade;

public interface TradeService {

	public void deleteAllTrade();

	public List<Trade> findAllByOrderByIdAsc();

	Trade saveTrade(Trade trade);

	Trade findTradeById(Long id);
}
