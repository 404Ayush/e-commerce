package com.example.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerce.domain.Constants;
import com.example.eCommerce.domain.PhoneHeaderRequest;
import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.service.PhoneHeaderService;


@RestController
public class ProductHeaderController {
	
	private final PhoneHeaderService service;

	@Autowired
	public ProductHeaderController(PhoneHeaderService service) {
		this.service = service;
	}
	
	@PostMapping(value=Constants.PHONE_HEADER_API_V1)
	public ResponseEntity<PhoneHeaderResponse> phoneHeaderInfo(@RequestBody PhoneHeaderRequest request){
		PhoneHeaderResponse response = service.getPhoneHeaderInfo(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
