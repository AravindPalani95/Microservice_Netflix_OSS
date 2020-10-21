package com.sb.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sb.store.modal.Item;
import com.sb.store.service.StoreService;

@RestController
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping(value = "/all-stock")
	public ResponseEntity<List<Item>> getAllStock(){
		List<Item> itemList = storeService.getAllStock();
		if(itemList == null)
			return new ResponseEntity<List<Item>>(HttpStatus.SERVICE_UNAVAILABLE);
		else
			return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/stock/{stockname}")
	public ResponseEntity<Item> getStock(@PathVariable("stockname") String stockName){
		Item itemList = storeService.getStock(stockName);
		return new ResponseEntity<Item>(itemList,HttpStatus.OK);
	}

}
