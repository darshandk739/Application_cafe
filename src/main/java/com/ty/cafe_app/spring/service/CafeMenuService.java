package com.ty.cafe_app.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cafe_app.spring.dao.CafeMenuDao;
import com.ty.cafe_app.spring.dto.CafeMenu;
import com.ty.cafe_app.spring.exception.NoSuchIdFoundException;
import com.ty.cafe_app.spring.exception.NotAbleToUpdateException;
import com.ty.cafe_app.spring.util.ResponseStructure;

@Service
public class CafeMenuService {

	@Autowired
	CafeMenuDao dao;
	
	public ResponseEntity<ResponseStructure<CafeMenu>> saveCafeMenu(CafeMenu menu){
		ResponseEntity<ResponseStructure<CafeMenu>> responseEntity;
		ResponseStructure<CafeMenu> responseStructure=new ResponseStructure<CafeMenu>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveCafeMenu(menu));
		return responseEntity=new ResponseEntity<ResponseStructure<CafeMenu>> (responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<CafeMenu>> updateCafeMenu(CafeMenu menu,int id){
		ResponseEntity<ResponseStructure<CafeMenu>> responseEntity;
		CafeMenu menu2=dao.getCafeMenuById(id);
		ResponseStructure<CafeMenu> responseStructure=new ResponseStructure<CafeMenu>();
		if(menu2!=null)
		{
			menu.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(dao.updateCafeMenu(menu));
		return responseEntity=new ResponseEntity<ResponseStructure<CafeMenu>> (responseStructure,HttpStatus.OK);
		}
		else
			 throw new NotAbleToUpdateException("Not Able To Update");
	}
	
	public ResponseEntity<ResponseStructure<CafeMenu>> getCafeMenuById(int id){
		ResponseEntity<ResponseStructure<CafeMenu>> responseEntity;
		ResponseStructure<CafeMenu> responseStructure=new ResponseStructure<CafeMenu>();
		CafeMenu menu2=dao.getCafeMenuById(id);
		if(menu2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Fetched");
		responseStructure.setData(dao.getCafeMenuById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<CafeMenu>> (responseStructure,HttpStatus.OK);
		}
		else
			 throw new NoSuchIdFoundException("No Id Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteCafeMenu(int id){
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteCafeMenuById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<String>> (responseStructure,HttpStatus.OK);
	}
	
}
