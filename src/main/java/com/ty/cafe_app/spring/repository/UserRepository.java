package com.ty.cafe_app.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cafe_app.spring.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
