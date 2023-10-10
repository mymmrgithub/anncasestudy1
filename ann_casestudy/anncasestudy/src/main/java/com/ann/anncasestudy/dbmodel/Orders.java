package com.ann.anncasestudy.dbmodel;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;
	//@OneToOne(targetEntity=Customers.class)
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customers customers;
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Products products;
	private Integer order_qty;
	private Integer order_status;
	private Date order_date;
	private Date dispatch_date;
	private String reference_no;
	
	
	public Date getDispatch_date() {
		return dispatch_date;
	}
	public void setDispatch_date(Date dispatch_date) {
		this.dispatch_date = dispatch_date;
	}
	public String getReference_no() {
		return reference_no;
	}
	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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
	
}
