package com.example.eCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eCommerce.domain.ProductHomeResponse;
import com.example.eCommerce.repository.ProductHomeRepository;

@Service
public class ProductHomeService {

	@Autowired
	ProductHomeRepository repository;
	
	public List<ProductHomeResponse> getHomeResponse() {
		return repository.getHomeResponse();
	}
}
