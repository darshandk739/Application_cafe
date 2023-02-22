package com.ty.cafe_app.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cafe_app.spring.dao.CafeItemsDao;
import com.ty.cafe_app.spring.dto.CafeItems;
import com.ty.cafe_app.spring.exception.NoSuchIdFoundException;
import com.ty.cafe_app.spring.exception.NotAbleToUpdateException;
import com.ty.cafe_app.spring.util.ResponseStructure;

@Service
public class CafeItemsService {

	@Autowired
	CafeItemsDao dao;
	
	public ResponseEntity<ResponseStructure<CafeItems>> saveCafeItems(CafeItems items){
		ResponseEntity<ResponseStructure<CafeItems>> responseEntity;
		ResponseStructure<CafeItems> responseStructure=new ResponseStructure<CafeItems>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveCafeItems(items));
		return responseEntity = new ResponseEntity<ResponseStructure<CafeItems>> (responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<CafeItems>> updateItems(CafeItems items,int id){
		ResponseEntity<ResponseStructure<CafeItems>> responseEntity;
		CafeItems items2=dao.getCafeItemsById(id);
		ResponseStructure<CafeItems> responseStructure=new ResponseStructure<CafeItems>();
		if(items2!=null)
		{
			items.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(dao.updateCafeItems(items));
		return responseEntity = new ResponseEntity<ResponseStructure<CafeItems>> (responseStructure,HttpStatus.OK);
		}
		else
			 throw new NotAbleToUpdateException("Not Able To Update");
	}
	
	public ResponseEntity<ResponseStructure<CafeItems>> getCafeItemsById(int id){
		ResponseEntity<ResponseStructure<CafeItems>> responseEntity;
		ResponseStructure<CafeItems> responseStructure=new ResponseStructure<CafeItems>();
		CafeItems items2=dao.getCafeItemsById(id);
		if(items2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Fetched");
		responseStructure.setData(dao.getCafeItemsById(id));
		return responseEntity = new ResponseEntity<ResponseStructure<CafeItems>> (responseStructure,HttpStatus.OK);
		}
		else
			 throw new NoSuchIdFoundException("No Id Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteItems(int id){
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteCafeItemsById(id));
		return responseEntity = new ResponseEntity<ResponseStructure<String>> (responseStructure,HttpStatus.OK);
	}
	
}
