package com.example.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerce.domain.Constants;
import com.example.eCommerce.domain.PhoneDetailsRequest;
import com.example.eCommerce.domain.PhoneDetailsResponse;
import com.example.eCommerce.service.PhoneDetailsService;

@RestController
public class ProductDetailsController {
	private final PhoneDetailsService service;

	@Autowired
	public ProductDetailsController(PhoneDetailsService service) {
		this.service = service;
	}
	
	@CrossOrigin
	@PostMapping(value=Constants.PHONE_DETAILS_API_V1)
	public ResponseEntity<PhoneDetailsResponse> phoneHeaderInfo(@RequestBody PhoneDetailsRequest request){
		PhoneDetailsResponse response = service.getPhoneDetailsInfo(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
