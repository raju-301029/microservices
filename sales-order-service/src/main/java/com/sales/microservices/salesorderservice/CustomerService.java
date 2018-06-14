package com.sales.microservices.salesorderservice;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-edge-server")
@RibbonClient(name = "customer-service")
public interface CustomerService {

	@GetMapping("customer-service/api/service1/customers")
	public List<SalesOrder> getAllCustomers();

	@GetMapping("customer-service/api/service1/customers/email/{emailId}")
	public SalesOrder getCustomerDetails(@PathVariable("emailId") String emailId);

}
