package com.payroll.microservices.roleservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "employee_role")
public class EmployeeRole {
	@Id
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "description")
	private String description;

	public EmployeeRole(Long roleID, String roleName, String description) {
		super();
		this.roleId = roleID;
		this.roleName = roleName;
		this.description = description;
	}

	public EmployeeRole() {

	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleID) {
		this.roleId = roleID;
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

	public void setDescription(String description) {
		this.description = description;
	}

}
