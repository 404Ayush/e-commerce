package com.example.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.repository.InsertHeaderRepository;

@Service
public class InsertHeaderService {
	
	@Autowired
	InsertHeaderRepository repository;
	
	public void savePhoneHeaderInfo(PhoneHeaderResponse request) {
		repository.savePhoneHeaderInfo(request);
	}
	
}
