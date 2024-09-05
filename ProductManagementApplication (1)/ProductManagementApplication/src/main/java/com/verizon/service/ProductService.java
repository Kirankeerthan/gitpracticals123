package com.verizon.service;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.verizon.dao.ProductDao;
import com.verizon.exceptiondemo.ProductNotFoundException;
import com.verizon.model.Product;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class ProductService {
	@Autowired
	ProductDao productDao;
	public String addProduct(Product product) {
	
		productDao.save(product);
		return "Added";
	}
	public   List<Product> getProducts() {
		//
		List<Product> productList=productDao.findAll();  //call dao method
		return productList;
	}
	
	public   Product getProduct(Integer id) throws ProductNotFoundException{
		Optional<Product> product= productDao.findById(id);
		return product.orElseThrow (()->  new ProductNotFoundException("The follwing id is not found"));
		//Product product=productDao.findById(id).get();
		//if(product==null)
			//throw new ProductNotFoundException("The follwing id is not found");//call dao method
		//return product;
	}
	
	public   List<Product> getProductsBetweenLowHigh(Integer low,Integer high) throws ProductNotFoundException {
		// 
		List<Product> productList=productDao.findAllProductBetweenPrice(low,high);
		if(productList.isEmpty())
			throw new ProductNotFoundException("The follwing id is not found");// call custom method  
		return productList;
	}
	public Product updatePlan(Integer pid,Product product) throws ProductNotFoundException {
		////call dao method
		Product p = productDao.findById(pid).get();
		if(p==null)
			throw new ProductNotFoundException("The follwing id is not found");
        productDao.save(product);
		return p;
	}
	public Product deletePlan(Integer pid) throws ProductNotFoundException    {
		Product pd = productDao.findById(pid).get();
		if(pd==null)
			throw new ProductNotFoundException("The follwing id is not found");

		productDao.deleteById(pid);
		return pd;
		}
	
	
	}
