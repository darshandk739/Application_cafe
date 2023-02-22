package com.ty.cafe_app.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cafe_app.spring.dao.ProductDao;
import com.ty.cafe_app.spring.dto.Product;
import com.ty.cafe_app.spring.exception.NoSuchIdFoundException;
import com.ty.cafe_app.spring.exception.NotAbleToUpdateException;
import com.ty.cafe_app.spring.util.ResponseStructure;


@Service
public class ProductService {

	@Autowired
	ProductDao dao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product){
		ResponseEntity<ResponseStructure<Product>> responseEntity;
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveProduct(product));
		return responseEntity=new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product,int id){
		ResponseEntity<ResponseStructure<Product>> responseEntity;
		Product product2=dao.getProductById(id);
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		if(product2!=null)
		{
			product.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(dao.updateProduct(product));
		return responseEntity=new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}
		else
			 throw new NotAbleToUpdateException("Not Able To Update");
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id){
		ResponseEntity<ResponseStructure<Product>> responseEntity;
		ResponseStructure<Product> responseStructure=new ResponseStructure<Product>();
		Product product2=dao.getProductById(id);
		if(product2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Fetched");
		responseStructure.setData(dao.getProductById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<Product>>(responseStructure,HttpStatus.OK);
		}
		else
			 throw new NoSuchIdFoundException("No Id Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id){
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteProductById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}
	
}
