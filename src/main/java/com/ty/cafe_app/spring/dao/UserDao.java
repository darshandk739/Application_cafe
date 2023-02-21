package com.ty.cafe_app.spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.cafe_app.spring.dto.User;
import com.ty.cafe_app.spring.repository.UserRepository;
@Repository
public class UserDao {

	@Autowired
	UserRepository repository;
	
	public User saveUSer(User user) {
		return repository.save(user);	
	}
	
	public User updateUSer(User user) {
		return repository.save(user);	
	}
	
	public User getUserById(int id) {
		Optional<User> optional=repository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
	}
	
	public String deleteUserById(int id) {
		repository.deleteById(id);
		return "deleted";
	}
}
