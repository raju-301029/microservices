package com.sales.microservices.salesorderservice;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesOrderServiceController {

	@Autowired
	SalesOrderRepository salesOrderRepository;

	@Autowired
	ItemService itemService;

	@Autowired
	CustomerService customerService;

	private static final Logger log = LoggerFactory.getLogger(SalesOrderServiceController.class);

	@PostMapping("/api/service3/orders/description/{description}/emailId/{emailId}/itemNames/{itemNames}")
	public SalesOrder createOrder(@PathVariable String description, @PathVariable String emailId,
			@PathVariable String[] itemNames) {

		Map<String, Integer> itemCount = new HashMap<String, Integer>();
		for (String item : itemNames) {
			if (null != itemCount.get(item)) {
				itemCount.put(item, itemCount.get(item) + 1);
			} else {
				itemCount.put(item, 1);
			}
		}

		SalesOrder customerObj = customerService.getCustomerDetails(emailId);
		if (null != customerObj) {
			customerObj.setDate(new Date());
			customerObj.setDescription(description);
			customerObj.setEmailId(emailId);
			Set<OrderLineItem> orderLineItemSet = new HashSet<>();

			itemCount.keySet().forEach(item -> {
				SalesOrder itemObj = itemService.getItemDetails(item);
				if (null != itemObj) {
					log.info("Item :" + item);
					OrderLineItem orderLineItem = new OrderLineItem();
					orderLineItem.setItemName(item);
					orderLineItem.setQuantity(itemCount.get(item));
					orderLineItemSet.add(orderLineItem);
					customerObj.setPrice(customerObj.getPrice() + (itemObj.getPrice() * itemCount.get(item)));
				} else {
					// Item not found
					log.info("Item not found:" + item);
				}
			});
			customerObj.setOrderLineItems(orderLineItemSet);
			salesOrderRepository.save(customerObj);

		} else {
			// emailId not found
			log.info("EmailId not found:" + emailId);
		}

		return customerObj;
	}

	@GetMapping("/api/service3/orders/{orderId}")
	public SalesOrder getOrderById(@PathVariable int orderId) {
		return salesOrderRepository.findOne(orderId);

	}

}
