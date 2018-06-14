package com.payroll.microservices.employeeservice;

import java.util.Date;

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
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	Environment environment;

	@Autowired
	EmployeeConfiguration employeeConfiguration;

	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/employee/{empId}")
	public Employee getEmployeeDetails(@PathVariable Long empId) {
		// Employee employee = new Employee("RAJU","KUMAR",301029L,new Date());
		log.info("inside  getEmployeeDetails:" + empId);
		Employee employee = employeeRepository.findOne(empId);
		System.out.println("before returnining" + employee.getFirstName());

		employee.setPort(Integer.parseInt(environment.getProperty("server.port")));
		return employee;
	}

	@GetMapping("/employee/fault-tolerance")
	@HystrixCommand(fallbackMethod = "fallbackEmployeeDetails")
	public Employee getEmployeeDetailsFaultTolerance() {
		throw new RuntimeException("Some Issue");
	}

	public Employee fallbackEmployeeDetails() {
		// return new Employee("firstName","lastName",101L,new Date());
		return new Employee(employeeConfiguration.getDefaultFirstName(), employeeConfiguration.getDefaultLastName(),
				101L, new Date());
	}
}
