package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ProductException;
import com.example.exception.salesOrderException;
import com.example.model.OrderList;
import com.example.model.Product;
import com.example.model.salesOrder;
import com.example.repository.ProductRepo;
import com.example.repository.salesRepo;

@Service
public class salesServiceImpl implements salesService {
	
	@Autowired
	private salesRepo srepo;
	
	@Autowired 
	private ProductRepo prepo;
	@Override
	public salesOrder addSalesOrder(salesOrder salesOrder) throws ProductException, salesOrderException {
		  List<OrderList> orderItems = salesOrder.getOrderItems();
	        for (OrderList order : orderItems) {
	            Product product = order.getProduct();
                int QuantityNow = product.getStockquantity()-order.getSales_quantity();
	            if (QuantityNow < 0) {
	                throw new ProductException("No product available");
	            }

	            product.setStockquantity(QuantityNow);
	            prepo.save(product);
	        }
	        return srepo.save(salesOrder);
	}
	@Override
	public List<salesOrder> allSaleOrder() throws salesOrderException {
		List<salesOrder> Sales =srepo.findAll();
		return Sales;
	}

}
