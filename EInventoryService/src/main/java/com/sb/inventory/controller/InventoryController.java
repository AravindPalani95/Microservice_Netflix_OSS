package com.sb.inventory.controller;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sb.inventory.modal.Item;

@RestController
public class InventoryController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Autowired
	private Environment environment;

	public List<Item> itemList;
	
	@PostConstruct
	public void setInventory(){
		itemList = new ArrayList<>();
		int port = Integer.parseInt(environment.getProperty("server.port"));
		Item item1 = new Item("Airpod 550",50,2545.00);
		item1.setPort(port);
		Item item2 = new Item("Band 5",20,3000.50);
		item2.setPort(port);
		itemList.add(item1);
		itemList.add(item2);
	}
	
	@GetMapping(value = "/stock",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> getInventoryStock(){
		LOG.info("List Of Inventory Items :",itemList);
		return new ResponseEntity<List<Item>>(itemList,HttpStatus.OK);
	}
	
	@GetMapping(value = "/stock/{stockname}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getInventoryStock(@PathVariable("stockname") String stockName){
		Item item = itemList.stream()
				.filter(it -> it.getItemName().equalsIgnoreCase(stockName)).findFirst().get();
		LOG.info("Inventory Item :",itemList);
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}
	
}
