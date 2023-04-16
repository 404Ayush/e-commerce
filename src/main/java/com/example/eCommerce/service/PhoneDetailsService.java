package com.example.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eCommerce.domain.PhoneDetailsRequest;
import com.example.eCommerce.domain.PhoneDetailsResponse;
import com.example.eCommerce.repository.PhoneDetailsRepository;

@Service
public class PhoneDetailsService {
	@Autowired
	PhoneDetailsRepository repository;
	
	public PhoneDetailsResponse getPhoneDetailsInfo(PhoneDetailsRequest request) {
		
		return repository.getPhoneDetailsResponse(request);
	}
}
