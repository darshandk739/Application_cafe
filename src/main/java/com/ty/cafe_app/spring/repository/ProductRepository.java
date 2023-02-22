package com.ty.cafe_app.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cafe_app.spring.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
