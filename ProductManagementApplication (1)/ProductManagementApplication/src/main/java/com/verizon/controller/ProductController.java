package com.verizon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.exceptiondemo.ProductNotFoundException;
import com.verizon.model.Product;
import com.verizon.service.ProductService;
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	@GetMapping("/product")
	public List<Product> getAllProducts() {  // need to implement
		List<Product> productList=productService.getProducts();  //sample list need to replace
				return productList;
	}
	@GetMapping("/product/{id}")
	public Product getProduct(Integer id) throws ProductNotFoundException {  // need to implement
		Product product=productService.getProduct(id);  //sample list need to replace
				return product;
	}
	@GetMapping("/product/{low}/{high}")
	public List<Product> getProductBetweenPriceRange(@PathVariable("low") Integer low,@PathVariable("high") Integer high) throws ProductNotFoundException {  // need to implement
		List<Product> productList=productService.getProductsBetweenLowHigh(low, high);  //sample list need to replace
		return productList;
	}
  @PostMapping("/product") 
	  public String  addProductDetails(@RequestBody	  Product product) { // need to implement
		productService.addProduct(product); 
	  return  "Added";
	  }
	
	@PutMapping("/product/{pid}") 
	public Product updateProductDetails(@PathVariable("pid") Integer pid,@RequestBody Product product) throws ProductNotFoundException {
		 // need to imple
		return  productService.updatePlan(pid,product);
	}
	
	@DeleteMapping("/product/{pid}") 
	public Product deleteProductDetails(@PathVariable("pid") Integer pid) throws ProductNotFoundException {
		// need to implement
		return  productService.deletePlan(pid); 
	}
	
}
