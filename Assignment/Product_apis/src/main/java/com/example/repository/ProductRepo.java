package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
