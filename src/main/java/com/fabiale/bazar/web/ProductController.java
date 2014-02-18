package com.fabiale.bazar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.bazar.model.Product;
import com.fabiale.bazar.model.Products;
import com.fabiale.bazar.repositories.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired ProductRepository repository;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> index() {
		return repository.findAll();
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody(required = true) Products products) {
		for (Product product : products.getProducts()) {
			repository.create(product);
		}
		return new ResponseEntity<Product>(HttpStatus.CREATED);
	}
}
