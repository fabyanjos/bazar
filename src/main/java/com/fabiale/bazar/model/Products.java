package com.fabiale.bazar.model;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
