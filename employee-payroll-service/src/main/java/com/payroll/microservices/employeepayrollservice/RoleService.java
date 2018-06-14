package com.payroll.microservices.employeepayrollservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="role-service",url="localhost:8101")
//@FeignClient(name="role-service")
@FeignClient(name = "zuul-edge-server")
@RibbonClient(name = "role-service")
public interface RoleService {
	// @GetMapping("/role/{roleName}")
	@GetMapping("/role-service/role/{roleName}")
	public EmployeePayroll getRoleByRoleName(@PathVariable("roleName") String roleName);

}
