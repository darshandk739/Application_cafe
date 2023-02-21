package com.ty.cafe_app.spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cafe_app.spring.dto.CafeMenu;
import com.ty.cafe_app.spring.repository.CafeMenuRepository;

@Repository
public class CafeMenuDao {
	@Autowired
	CafeMenuRepository repository;
	
	public CafeMenu saveCafeMenu(CafeMenu menu) {
		return repository.save(menu);	
	}
	
	public CafeMenu updateCafeMenu(CafeMenu menu) {
		return repository.save(menu);	
	}
	
	public CafeMenu getCafeMenuById(int id) {
		Optional<CafeMenu> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteCafeMenuById(int id) {
		repository.deleteById(id);
		return "deleted";
	}
}
