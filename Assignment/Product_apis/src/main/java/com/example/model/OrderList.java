package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OrderList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Order_id;

	@ManyToOne
	private Product product;
	
	private Integer sales_quantity;
	
    private Double discount;
   
    @ManyToOne
    @JsonIgnore
    public salesOrder sOrder;

}
