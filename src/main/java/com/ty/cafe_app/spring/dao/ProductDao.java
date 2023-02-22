package com.ty.cafe_app.spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cafe_app.spring.dto.Product;
import com.ty.cafe_app.spring.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);	
	}
	
	public Product updateProduct(Product product) {
		return repository.save(product);	
	}
	
	public Product getProductById(int id) {
		Optional<Product> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "deleted";
	}
}
