package com.example.eCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.eCommerce.domain.ProductHomeResponse;
import com.example.eCommerce.repository.ProductHomeRepository;

@Service
@EnableCaching
public class ProductHomeService {

	@Autowired
	ProductHomeRepository repository;


	@Cacheable(key = "#homeId", value = "homeProductCache")
	public List<ProductHomeResponse> getHomeResponse(String homeId) {
		return repository.getHomeResponse();
	}
}
