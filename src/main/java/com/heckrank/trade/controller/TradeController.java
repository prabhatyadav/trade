package com.heckrank.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heckrank.trade.model.Trade;
import com.heckrank.trade.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	private TradeService tradeService;

	// 1.
	@RequestMapping(value = "/erase", method = RequestMethod.DELETE)
	public ResponseEntity deleteAllTrade() {
		tradeService.deleteAllTrade();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 2.
	@RequestMapping(value = "/trades", method = RequestMethod.POST)
	public ResponseEntity saveTrades(@RequestBody Trade trade) {
		Trade savedTrade = tradeService.saveTrade(trade);
		if (savedTrade != null) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	// 3.
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity fetchTradeById(@PathVariable("id") long id) {
		Trade trade = tradeService.findTradeById(id);
		if (trade == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(trade, HttpStatus.OK);
	}

	// 4 .
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity fetchAllTrade() {
		return new ResponseEntity<>(tradeService.findAllByOrderByIdAsc(), HttpStatus.OK);
	}

	// 5. trades/users/{userID} :Filtered By userId Symbol user not exist : 404 sent
	// on array of trade order by trade id : 200

	// 6. trades/stocks/{stockSymbol} : Filter By StockSymbol : 404 sent on array of
	// trade order by trade id: 200

	// 7. trades/users/{userID}/stocks/{stockSymbol} : Filter By StockSymbol : 404
	// return trade filter by UserId and StockSymbol Order By Trade Id

}
