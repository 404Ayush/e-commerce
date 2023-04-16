package com.example.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eCommerce.domain.PhoneHeaderRequest;
import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.repository.PhoneHeaderRepository;

@Service
public class PhoneHeaderService {
	
	@Autowired
	PhoneHeaderRepository repository;
	
	public PhoneHeaderResponse getPhoneHeaderInfo(PhoneHeaderRequest request) {
		
		return repository.getPhoneHeaderInfo(request);
	}
}
