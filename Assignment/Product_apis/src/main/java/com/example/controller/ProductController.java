package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@PostMapping("/create")
	public ResponseEntity<Product> createproduct(@RequestBody Product product) throws ProductException
	{
//		System.out.println(product.getBrandName());
	Product pp = pservice.createProduct(product);
		
		return new ResponseEntity<Product>(pp,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/{quantity}")
	public ResponseEntity<Product> IncreaseProductQuantity(@PathVariable("id") Integer Id, @PathVariable("quantity") Integer qty) throws ProductException{
		Product pInc = pservice.IncreaseProductQuantity(Id, qty);
		
		return new ResponseEntity<>(pInc, HttpStatus.ACCEPTED);
	}
	@PutMapping("/{id}/{decquantity}")
	public ResponseEntity<Product> decreaseProductQuantity(@PathVariable("id") Integer Id, @PathVariable("quantity") Integer qty) throws ProductException{
		Product pDec= pservice.DecreseProductQuantity(Id, qty);
		
		return new ResponseEntity<>(pDec, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductException{
		List<Product> listofproduct = pservice.getAllProduct();
		return new ResponseEntity<List<Product>>(listofproduct, HttpStatus.OK);
	}

}
