package com.heckrank.trade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.heckrank.trade.model.Trade;

public interface TradeRepository  extends CrudRepository<Trade, Long>{
  public List<Trade> findAllByOrderByIdAsc();
}
