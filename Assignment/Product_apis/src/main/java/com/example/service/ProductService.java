package com.example.service;

import java.util.List;

import com.example.exception.ProductException;
import com.example.model.Product;

public interface ProductService {
	
public Product createProduct(Product product) throws ProductException;
	
    public Product IncreaseProductQuantity(Integer productId,Integer quantity) throws ProductException;
    
	public Product DecreseProductQuantity(Integer productId,Integer quantity) throws ProductException;
	
	public List<Product> getAllProduct();

}
