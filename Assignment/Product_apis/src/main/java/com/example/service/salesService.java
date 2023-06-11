package com.example.service;

import java.util.List;

import com.example.exception.ProductException;
import com.example.exception.salesOrderException;
import com.example.model.salesOrder;

public interface salesService {

 public salesOrder addSalesOrder(salesOrder salesOrder) throws ProductException ,salesOrderException;
	 
 public List<salesOrder> allSaleOrder() throws salesOrderException;
}
