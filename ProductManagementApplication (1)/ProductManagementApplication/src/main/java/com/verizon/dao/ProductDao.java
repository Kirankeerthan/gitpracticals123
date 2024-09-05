package com.verizon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verizon.model.Product;

@Repository

public interface ProductDao  extends JpaRepository<Product,Integer>{
	
	@Query("Select p from Product p where p.price Between ?1 and ?2")
	List<Product> findAllProductBetweenPrice(Integer low,Integer high);

	}
