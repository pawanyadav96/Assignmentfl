package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ProductException;
import com.example.model.Product;
import com.example.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepo prepo;

	@Override
	public Product createProduct(Product product) throws ProductException {
	return prepo.save(product);
		
		
		
	
	}

	@Override
	public Product IncreaseProductQuantity(Integer productId, Integer quantity) throws ProductException {
		Optional<Product> pod =prepo.findById(productId);
		
		if (pod.isEmpty()) {
			throw new ProductException("Product does not exist");
		}
		else
		{
			Product product=pod.get();
			product.setStockquantity(product.getStockquantity()+quantity);
			return prepo.save(product);
		}
	}

	@Override
	public Product DecreseProductQuantity(Integer productId, Integer quantity) throws ProductException {
		
		Optional<Product> pod =prepo.findById(productId);
		
		if (pod.isEmpty()) {
			throw new ProductException("Product does not exist");
		}
		else
		{
			Product pp=pod.get();
			
			if(pp.getStockquantity()<0 ||pp.getStockquantity() <quantity)
			{
				throw new ProductException("quantity should be greater than 0 or the entered quantity");
			}
			else
			{
				pp.setStockquantity(pp.getStockquantity()-quantity);
				return prepo.save(pp);
			}
		}
		
		
	}

	@Override
	public List<Product> getAllProduct() {
		 List<Product> products =prepo.findAll();
		 return products;
		
	}
	
}
