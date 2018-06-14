package com.payroll.microservices.employeepayrollservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeePayrollController {

	@Autowired
	EmployeePayrollRepository employeePayrollRepository;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	RoleService roleService;

	private static final Logger log = LoggerFactory.getLogger(EmployeePayrollController.class);

	@PostMapping("/employee/{empId}/role/{roleName}")
	public EmployeePayroll insertEmployeePayrollDetails(@PathVariable Long empId, @PathVariable String roleName) {
		/*
		 * System.out.println("empID:"+empId+"roleName:"+roleName); EmployeePayroll
		 * employeePayroll = new
		 * EmployeePayroll(1L,100L,"AAA","BBB",1001L,"HR","Human Resource");
		 * employeePayrollRepository.save(employeePayroll);
		 */

		/*
		 * ResponseEntity<EmployeePayroll> employeeEntity = new
		 * RestTemplate().getForEntity("http://localhost:8080/employee/{empId}",
		 * EmployeePayroll.class,empId); EmployeePayroll employeePayroll =
		 * employeeEntity.getBody();
		 * 
		 * ResponseEntity<EmployeePayroll> roleEntity = new
		 * RestTemplate().getForEntity("http://localhost:8101/role/{roleName}",
		 * EmployeePayroll.class,roleName);
		 * employeePayroll.setRoleId(roleEntity.getBody().getRoleId());
		 * employeePayroll.setRoleName(roleEntity.getBody().getRoleName());
		 * employeePayroll.setDescription(roleEntity.getBody().getDescription());
		 * employeePayrollRepository.save(employeePayroll);
		 */

		log.info("inside insertEmployeePayrollDetails");

		// using feignclient
		EmployeePayroll employeePayroll = employeeService.getEmployeeDetails(empId);
		EmployeePayroll roleObj = roleService.getRoleByRoleName(roleName);
		employeePayroll.setRoleId(roleObj.getRoleId());
		employeePayroll.setRoleName(roleObj.getRoleName());
		employeePayroll.setDescription(roleObj.getDescription());
		employeePayrollRepository.save(employeePayroll);
		return employeePayroll;
	}

}
