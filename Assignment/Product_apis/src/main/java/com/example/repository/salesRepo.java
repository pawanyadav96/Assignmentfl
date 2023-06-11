package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.salesOrder;

public interface salesRepo extends JpaRepository<salesOrder, Integer> {

}
