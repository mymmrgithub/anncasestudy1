package com.ann.anncasestudy.dto;

public class ProductsDto {
	
	private Integer  product_id;
	private String product_name;
	private String product_type;
	private Integer available_qty;
	private Integer order_qty;
	private Integer order_id;
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	private String product_desc;
	private String product_img;
	private String units;
	private Integer price_per_units;
	
	public Integer getOrder_qty() {
		return order_qty;
	}
	public void setOrder_qty(Integer order_qty) {
		this.order_qty = order_qty;
	}
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
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
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
