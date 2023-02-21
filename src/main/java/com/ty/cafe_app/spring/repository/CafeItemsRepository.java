package com.ty.cafe_app.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cafe_app.spring.dto.CafeItems;

public interface CafeItemsRepository extends JpaRepository<CafeItems, Integer>{

}
