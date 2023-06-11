package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ProductException;
import com.example.exception.salesOrderException;
import com.example.model.salesOrder;
import com.example.service.salesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/salesOrder")
public class salesController {
	
	@Autowired
	private salesService sservice;
	
	@PostMapping("/add")
	public ResponseEntity<salesOrder> addSalesOrder(@Valid @RequestBody salesOrder salesorder) throws salesOrderException, ProductException {
		salesOrder addsales =  sservice.addSalesOrder(salesorder);
		return new ResponseEntity<salesOrder>(addsales,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<salesOrder>> getAllSalesOrder() throws salesOrderException{
		List<salesOrder> list = sservice.allSaleOrder();
		return new ResponseEntity<List<salesOrder>>(list, HttpStatus.OK);
	}

}
