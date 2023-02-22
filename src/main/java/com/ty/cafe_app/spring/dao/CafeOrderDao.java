package com.ty.cafe_app.spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cafe_app.spring.dto.CafeOrder;
import com.ty.cafe_app.spring.repository.CafeOrderRepository;

@Repository
public class CafeOrderDao {
	@Autowired
	private CafeOrderRepository repository;
	
	public CafeOrder saveCafeOrder(CafeOrder cafeOrder) {
		return repository.save(cafeOrder);	
	}
	
	public CafeOrder updateCafeOrder(CafeOrder cafeOrder) {
		return repository.save(cafeOrder);	
	}
	
	public CafeOrder getCafeOrderById(int id) {
		Optional<CafeOrder> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteCafeOrderById(int id) {
		repository.deleteById(id);
		return "deleted";
	}
}