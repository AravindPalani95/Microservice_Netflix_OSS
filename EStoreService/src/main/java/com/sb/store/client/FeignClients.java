package com.sb.store.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sb.store.modal.Item;

public class FeignClients {
	
	@FeignClient(name = "inventory-service")
	@RibbonClient(name = "inventory-service")
	public interface InventoryClient{
		
		@GetMapping(value = "/inventory/stock",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Item>> getInventoryStock();
		
		@GetMapping(value = "/inventory/stock/{stockname}",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Item> getInventoryStockByName(@PathVariable("stockname") String stockName);
		
	}

}
