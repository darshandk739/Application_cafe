package com.ty.cafe_app.spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cafe_app.spring.dto.CafeItems;
import com.ty.cafe_app.spring.repository.CafeItemsRepository;

@Repository
public class CafeItemsDao {

	@Autowired
	private CafeItemsRepository repository;
	
	public CafeItems saveCafeItems(CafeItems items) {
		return repository.save(items);	
	}
	
	public CafeItems updateCafeItems(CafeItems items) {
		return repository.save(items);	
	}
	
	public CafeItems getCafeItemsById(int id) {
		Optional<CafeItems> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteCafeItemsById(int id) {
		repository.deleteById(id);
		return "deleted";
	}
}
