package com.ty.cafe_app.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cafe_app.spring.dao.UserDao;
import com.ty.cafe_app.spring.dto.User;
import com.ty.cafe_app.spring.exception.NoSuchIdFoundException;
import com.ty.cafe_app.spring.exception.NotAbleToUpdateException;
import com.ty.cafe_app.spring.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveUSer(user));
		return responseEntity=new ResponseEntity<ResponseStructure<User>> (responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user,int id){
		ResponseEntity<ResponseStructure<User>> responseEntity;
		User user2=dao.getUserById(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		if(user2!=null)
		{
			user.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(dao.updateUSer(user));
		return responseEntity=new ResponseEntity<ResponseStructure<User>> (responseStructure,HttpStatus.OK);
		}
		else
		 throw new NotAbleToUpdateException("Not Able To Update");
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id){
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		User user2=dao.getUserById(id);
		if(user2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Fetched");
		responseStructure.setData(dao.getUserById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<User>> (responseStructure,HttpStatus.OK);
		}
		else
			 throw new NoSuchIdFoundException("No Id Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUser(int id){
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteUserById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<String>> (responseStructure,HttpStatus.OK);
	}
	
}
