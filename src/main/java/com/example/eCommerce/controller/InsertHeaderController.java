package com.example.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerce.domain.Constants;
import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.service.InsertHeaderService;

@RestController
public class InsertHeaderController {
	private final InsertHeaderService service;

	@Autowired
	public InsertHeaderController(InsertHeaderService service) {
		this.service = service;
	}
	
	@PostMapping(value=Constants.INSERT_HEADER_API_V1, consumes = {"application/json"})
	public ResponseEntity<PhoneHeaderResponse> phoneHeaderInfo(@RequestBody PhoneHeaderResponse request){
		service.savePhoneHeaderInfo(request);
		return new ResponseEntity<>(request, HttpStatus.CREATED);
	}
}
