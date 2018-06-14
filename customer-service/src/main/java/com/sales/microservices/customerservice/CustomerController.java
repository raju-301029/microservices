package com.sales.microservices.customerservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	Environment environment;

	@Autowired
	CustomerConfiguration customerConfiguration;

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/api/service1/customers")
	public List<Customer> getAllCustomers() {
		log.info("getAllCustomers:");
		List<Customer> customers = customerRepository.findAll();
		log.info("getAllCustomers size" + customers.size());

		return customers;
	}

	@GetMapping("/api/service1/customers/email/{emailId}")
	public Customer getCustomerDetails(@PathVariable("emailId") String emailId) {

		log.info("inside  getEmployeeDetails:" + emailId);
		Customer customer = customerRepository.findOne(emailId);
		System.out.println("before returnining" + customer.getFirstName());

		customer.setPort(Integer.parseInt(environment.getProperty("server.port")));
		return customer;
	}

	@GetMapping("/customer/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackCustomerDetails")
	public Customer getCustomerDetailsFaultTolerance() {
		throw new RuntimeException("Some Issue");
	}

	public Customer fallbackCustomerDetails() {
		return new Customer(customerConfiguration.getDefaultEmail(), customerConfiguration.getDefaultFirstName(),
				customerConfiguration.getDefaultLastName());
	}

}
