package com.example.eCommerce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.eCommerce.domain.PhoneDetailsRequest;
import com.example.eCommerce.domain.PhoneDetailsResponse;
import com.example.eCommerce.domain.PhoneSize;

@Repository
public class PhoneDetailsRepository {
	
	private final String ID = "ID";
	private final String DISPLAY_SIZE = "DISPLAY_SIZE";
	private final String DISPLAY_TYPE = "DISPLAY_TYPE";
	private final String PROCESSOR = "PROCESSOR";
	private final String BATTERY = "BATTERY";
	private final String SIZE_HEIGHT = "SIZE_HEIGHT";
	private final String SIZE_WIDTH = "SIZE_WIDTH";
	private final String SIZE_THICKNESS = "SIZE_THICKNESS";
	private final String SPEAKER_TYPE = "SPEAKER_TYPE";
	private final String SPEAKER_COMMENT = "SPEAKER_COMMENT";
	private final String BOX_CONTENT = "BOX_CONTENT";
	
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String SQL_SELECT_PHONE_DETAILS = "SELECT * FROM PHONE_DETAILS WHERE PHONE_ID = :ID";
	
	public PhoneDetailsResponse getPhoneDetailsResponse(PhoneDetailsRequest request) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue(ID, request.getId());
		
		PhoneDetailsResponse response = new PhoneDetailsResponse();
		PhoneSize phoneSize = new PhoneSize();
		
		jdbcTemplate.query(SQL_SELECT_PHONE_DETAILS, parameterSource, results -> {
			response.setDisplaySize(results.getString(DISPLAY_SIZE));
			response.setDisplayType(results.getString(DISPLAY_TYPE));
			response.setProcessor(results.getString(PROCESSOR));
			response.setBattery(results.getString(BATTERY));
			response.setSpeakerType(results.getString(SPEAKER_TYPE));
			response.setSpeakerComment(results.getString(SPEAKER_COMMENT));
			response.setBoxContent(results.getString(BOX_CONTENT));
			
			phoneSize.setHeight(results.getString(SIZE_HEIGHT));
			phoneSize.setWidth(results.getString(SIZE_WIDTH));
			phoneSize.setThickness(results.getString(SIZE_THICKNESS));
			
			response.setSize(phoneSize);
		});
		
		return response;
	}

}
