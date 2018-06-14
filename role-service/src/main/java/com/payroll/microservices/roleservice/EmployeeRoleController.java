package com.payroll.microservices.roleservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRoleController {

	@Autowired
	EmployeeRoleRepository employeeRoleRepository;

	private static final Logger log = LoggerFactory.getLogger(EmployeeRoleController.class);

	@GetMapping("/role/{roleName}")
	public EmployeeRole getRoleByRoleName(@PathVariable String roleName) {
		log.info(" inside getRoleByRoleName:" + roleName);
		EmployeeRole employeeRole = employeeRoleRepository.findByRoleName(roleName);
		System.out.println("employeeRole:" + employeeRole);
		return employeeRole;
	}

}
