package com.payroll.microservices.employeepayrollservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeePayroll {

	@Id
	@Column(name = "payroll_Id")
	@GeneratedValue
	private Long payrollId;

	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "emp_id")
	private Long empId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_desc")
	private String description;

	private int port;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Long getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String roleDescription) {
		this.description = roleDescription;
	}

	public EmployeePayroll(Long payrollId, Long empId, String firstName, String lastName, Long roleId, String roleName,
			String description) {
		super();
		this.payrollId = payrollId;
		this.roleId = roleId;
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleName = roleName;
		this.description = description;
	}

	public EmployeePayroll() {

	}

}
