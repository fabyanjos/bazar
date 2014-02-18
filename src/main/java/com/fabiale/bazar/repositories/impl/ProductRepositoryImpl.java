package com.fabiale.bazar.repositories.impl;

import org.springframework.stereotype.Repository;

import com.fabiale.bazar.model.Product;
import com.fabiale.bazar.repositories.ProductRepository;

@Repository
public class ProductRepositoryImpl extends GenericRepositoryImpl<Product, Integer> implements ProductRepository {
	
	public ProductRepositoryImpl() {
		super(Product.class);
	}
}
