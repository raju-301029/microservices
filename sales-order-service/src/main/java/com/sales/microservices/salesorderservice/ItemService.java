package com.sales.microservices.salesorderservice;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-edge-server")
@RibbonClient(name = "item-service")
public interface ItemService {

	@GetMapping("item-service/api/service2/items")
	public List<SalesOrder> getAllItems();

	@GetMapping("item-service/api/service2/items/{itemname}")
	public SalesOrder getItemDetails(@PathVariable("itemname") String itemname);

}
