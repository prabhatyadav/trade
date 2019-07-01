package com.heckrank.trade.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heckrank.trade.model.Trade;
import com.heckrank.trade.repository.TradeRepository;
import com.heckrank.trade.service.TradeService;
@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	@Override
	public void deleteAllTrade() {
		tradeRepository.deleteAll();
	}

	@Override
	public List<Trade> findAllByOrderByIdAsc() {
		return tradeRepository.findAllByOrderByIdAsc();
	}

	@Override
	public Trade saveTrade(Trade trade) {
		Trade savedTrade = null;
		if (trade != null) {
			if(tradeRepository.existsById(
					trade.getId())){
				return savedTrade;
			}
			savedTrade = tradeRepository.save(trade);
		}
		return savedTrade;
	}

	@Override
	public Trade findTradeById(Long id) {
		Optional<Trade> tradeOptional = tradeRepository.findById(id);
		if(tradeOptional.isPresent()) {
			return tradeOptional.get();
		}else {
			return null;
		}
	}

	public void deleteTradeById(Long id) {
		tradeRepository.deleteById(id);
	}

}
