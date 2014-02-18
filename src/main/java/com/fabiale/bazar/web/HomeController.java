package com.fabiale.bazar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabiale.bazar.model.Product;
import com.fabiale.bazar.repositories.ProductRepository;

@Controller
public class HomeController {
	
	@Autowired ProductRepository repository;

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.HEAD })
	public String home(ModelMap modelMap) {
		
		List<Product> products = repository.findAll();
		modelMap.addAttribute("products", products);
		
		return "index";
	}
}
