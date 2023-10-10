package com.ann.anncasestudy.dbmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  product_id;
	private String product_name;
	private String product_type;
	private Integer available_qty;
	private String product_desc;
	private String units;
	private Integer price_per_units;
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public Integer getPrice_per_units() {
		return price_per_units;
	}
	public void setPrice_per_units(Integer price_per_units) {
		this.price_per_units = price_per_units;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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
