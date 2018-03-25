package com.sepient.globoMartH2DB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sepient.globoMartH2DB.repository.Product;
import com.sepient.globoMartH2DB.repository.ProductCatalogRepository;

@RestController
@RequestMapping("/productCatalogueService")
public class ProductCatalogueController {

	@Autowired
	ProductCatalogRepository repository;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Long> addProduct(@RequestBody Product product) {

		Product p = repository.save(new Product(product.getName(), product.getType()));

		return new ResponseEntity<>(p.productId, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{productType}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findProductByType(@PathVariable("productType") String type) {
		return new ResponseEntity<>(repository.findByType(type), HttpStatus.OK);

	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeProduct(@PathVariable("productId") long id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("unsuccess server error of wrong id", HttpStatus.BAD_REQUEST);
		}
	}

}
