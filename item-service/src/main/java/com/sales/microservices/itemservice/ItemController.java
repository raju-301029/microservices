package com.sales.microservices.itemservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/api/service2/items")
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@GetMapping("/api/service2/items/{itemname}")
	public Item getItemDetails(@PathVariable String itemname) {
		Item item = itemRepository.findByName(itemname);
		return item;
	}

}
