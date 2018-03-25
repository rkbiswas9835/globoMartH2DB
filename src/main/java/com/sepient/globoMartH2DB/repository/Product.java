package com.sepient.globoMartH2DB.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	public Long productId;
	public String name;
	public String type;
	
	public Product() {
		super();
	}
	public Product(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", type=" + type + "]";
	}

}
