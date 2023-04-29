package com.example.eCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerce.domain.Constants;
import com.example.eCommerce.domain.ProductHomeResponse;
import com.example.eCommerce.service.ProductHomeService;

@RestController
public class ProductHomeController {
	private final ProductHomeService service;

	@Autowired
	public ProductHomeController(ProductHomeService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@GetMapping(value=Constants.PHONE_HOME_API_V1)
	public ResponseEntity<List<ProductHomeResponse>> phoneHomeInfo(@PathVariable("homeId") String homeId){
		List<ProductHomeResponse> response = service.getHomeResponse(homeId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
