package com.example.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eCommerce.publisher.Publisher;

@RestController
public class PublisherController {

	@Autowired
	private Publisher publisher;

	@PostMapping(value="/testPub")
	public ResponseEntity<String> pubTest(@RequestBody String request){
		//PhoneDetailsResponse response = service.getPhoneDetailsInfo(request);
		publisher.sendToKafka(request);
		return new ResponseEntity<>("published?", HttpStatus.OK);
	}
}
