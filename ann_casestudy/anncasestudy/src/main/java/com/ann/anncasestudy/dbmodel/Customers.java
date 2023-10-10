package com.ann.anncasestudy.dbmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customer_id;
	private Integer admin_role;
	private String password;
	private String name;
	private String email;
	private String contact;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(Integer admin_role) {
		this.admin_role = admin_role;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
