package com.example.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerce.domain.Constants;
import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.service.PhoneHeaderService;

@RestController
public class InsertHeaderController {
	private final PhoneHeaderService service;

	@Autowired
	public InsertHeaderController(PhoneHeaderService service) {
		this.service = service;
	}
	
	@GetMapping(value=Constants.INSERT_HEADER_API_V1)
	public ResponseEntity<PhoneHeaderResponse> phoneHeaderInfo(){
		PhoneHeaderResponse response = service.getPhoneHeaderInfo();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
