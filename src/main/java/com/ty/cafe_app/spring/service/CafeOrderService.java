package com.ty.cafe_app.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.cafe_app.spring.dao.CafeOrderDao;
import com.ty.cafe_app.spring.dto.CafeOrder;
import com.ty.cafe_app.spring.dto.Product;
import com.ty.cafe_app.spring.exception.NoSuchIdFoundException;
import com.ty.cafe_app.spring.exception.NotAbleToUpdateException;
import com.ty.cafe_app.spring.util.ResponseStructure;

@Service
public class CafeOrderService {

	@Autowired
	CafeOrderDao dao;
	
	public ResponseEntity<ResponseStructure<CafeOrder>> saveCafeOrder(CafeOrder cafeOrder){
		ResponseEntity<ResponseStructure<CafeOrder>> responseEntity;
		List<Product> list=cafeOrder.getProduct();
		double totalCost=0.0;
		for(Product product:list) {
			totalCost=totalCost+(product.getPrice()*product.getQty());
		}
		totalCost=totalCost+(0.18*totalCost);
		cafeOrder.setTotalcost(totalCost);
		ResponseStructure<CafeOrder> responseStructure=new ResponseStructure<CafeOrder>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveCafeOrder(cafeOrder));
		return responseEntity=new ResponseEntity<ResponseStructure<CafeOrder>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<CafeOrder>> updateFoodOrder(CafeOrder cafeOrder,int id){
		ResponseEntity<ResponseStructure<CafeOrder>> responseEntity;
		List<Product> list=cafeOrder.getProduct();
		double totalCost=0.0;
		for(Product product:list) {
			totalCost=totalCost+(product.getPrice()*product.getQty());
		}
		totalCost=totalCost+(0.18*totalCost);
		cafeOrder.setTotalcost(totalCost);
		CafeOrder cafeOrder2=dao.getCafeOrderById(id);
		ResponseStructure<CafeOrder> responseStructure=new ResponseStructure<CafeOrder>();
		if(cafeOrder2!=null)
		{
			cafeOrder.setId(id);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Updated");
		responseStructure.setData(dao.updateCafeOrder(cafeOrder));
		return responseEntity=new ResponseEntity<ResponseStructure<CafeOrder>>(responseStructure,HttpStatus.OK);
		}
		else
			 throw new NotAbleToUpdateException("Not Able To Update");
	}
	
	public ResponseEntity<ResponseStructure<CafeOrder>> getCafeOrderById(int id){
		ResponseEntity<ResponseStructure<CafeOrder>> responseEntity;
		ResponseStructure<CafeOrder> responseStructure=new ResponseStructure<CafeOrder>();
		CafeOrder cafeOrder2=dao.getCafeOrderById(id);
		if(cafeOrder2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Fetched");
		responseStructure.setData(dao.getCafeOrderById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<CafeOrder>>(responseStructure,HttpStatus.OK);
		}
		else
			 throw new NoSuchIdFoundException("No Id Found");
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteFoodOrder(int id){
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(dao.deleteCafeOrderById(id));
		return responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
	}
	
}
