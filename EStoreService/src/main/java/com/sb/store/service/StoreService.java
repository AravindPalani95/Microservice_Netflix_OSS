package com.sb.store.service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sb.store.client.FeignClients;
import com.sb.store.modal.Item;

@Service
public class StoreService {
	
	private static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private FeignClients.InventoryClient inventoryClient;
	
	//fallbackmethod will be called if time exceeded or exception occured
	@HystrixCommand(fallbackMethod = "getAllStockFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
	public List<Item> getAllStock(){
		ResponseEntity<List<Item>> itemListEntity = inventoryClient.getInventoryStock();
		return itemListEntity.getBody();
	}
	
	public Item getStock(String stockName){
		ResponseEntity<Item> itemListEntity = inventoryClient.getInventoryStockByName(stockName);
		return itemListEntity.getBody();
	}
	
	public List<Item> getAllStockFallBack(){
		LOG.info("TimeExceeded or Exception occured in API Call");
		return null;
	}
	
}
