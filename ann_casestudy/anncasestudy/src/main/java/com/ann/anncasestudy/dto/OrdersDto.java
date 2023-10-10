package com.ann.anncasestudy.dto;

import java.sql.Date;
import java.util.List;

import com.ann.anncasestudy.dbmodel.Customers;

public class OrdersDto {
	
	
	private Customers customers;
	private List<ProductsDto> products;
	public List<ProductsDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductsDto> products) {
		this.products = products;
	}
	private Integer order_qty;
	private Integer order_status;
	private Date order_date;
	private String name;
	private String email;
	private String contact;
	private String product_name;
	private String product_type;
	private Integer available_qty;
	private String product_desc;
	
	
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public Integer getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(Integer order_qty) {
		this.order_qty = order_qty;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public Integer getAvailable_qty() {
		return available_qty;
	}
	public void setAvailable_qty(Integer available_qty) {
		this.available_qty = available_qty;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	
	
}
