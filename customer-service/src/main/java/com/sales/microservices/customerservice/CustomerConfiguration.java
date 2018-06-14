package com.sales.microservices.customerservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "customer-service")
@Component
public class CustomerConfiguration {
	private String defaultFirstName;
	private String defaultLastName;
	private String defaultEmail;

	public String getDefaultFirstName() {
		return defaultFirstName;
	}

	public void setDefaultFirstName(String defaultFirstName) {
		this.defaultFirstName = defaultFirstName;
	}

	public String getDefaultLastName() {
		return defaultLastName;
	}

	public void setDefaultLastName(String defaultLastName) {
		this.defaultLastName = defaultLastName;
	}

	public String getDefaultEmail() {
		return defaultEmail;
	}

	public void setDefaultEmail(String defaultEmail) {
		this.defaultEmail = defaultEmail;
	}
}
