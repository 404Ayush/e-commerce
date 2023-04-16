package com.example.eCommerce.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.example.eCommerce.domain.PhoneHeaderResponse;

@Repository
public class InsertHeaderRepository {
	private final String ID = "ID";
	private final String NAME = "NAME";
	private final String COLOR_OPTION = "COLOR_OPTION";
	private final String RAM_OPTION = "RAM_OPTION";
	private final String BRAND = "BRAND";
	private final String WARRANTY = "WARRANTY";
	
	private final String INSERT_PHONE_HEADER = "INSERT INTO PHONE_HEADER ("
			+ "ID, NAME, COLOR_OPTION, RAM_OPTION, BRAND, WARRANTY)"
			+ "VALUES("
			+ ":ID, :NAME, :COLOR_OPTION, :RAM_OPTION, :BRAND, :WARRANTY)";
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	
	public void savePhoneHeaderInfo(PhoneHeaderResponse request) {
		UUID uuid = UUID.randomUUID();
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource
		.addValue(NAME, request.getName())
		.addValue(ID, uuid.toString())
		.addValue(COLOR_OPTION, request.getColorOptions())
		.addValue(RAM_OPTION, request.getRamOptions())
		.addValue(BRAND, request.getBrand())
		.addValue(WARRANTY, request.getWarranty());
		
		jdbcTemplate.update(INSERT_PHONE_HEADER, parameterSource);
	}
	
	public void saveMultiplePhoneHeaderInfo(PhoneHeaderResponse request) {
		
		StopWatch timer = new StopWatch();
	  
	    List<MapSqlParameterSource> params = new ArrayList<MapSqlParameterSource>();
	    for (int i=0; i<1000; i++) {
	    	UUID uuid = UUID.randomUUID();
	    	
	      MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource
			.addValue(NAME, request.getName())
			.addValue(ID, uuid.toString())
			.addValue(COLOR_OPTION, request.getColorOptions())
			.addValue(RAM_OPTION, request.getRamOptions())
			.addValue(BRAND, request.getBrand())
			.addValue(WARRANTY, request.getWarranty());
	      params.add(parameterSource);
	    }
	    timer.start(); 
	    jdbcTemplate.batchUpdate(INSERT_PHONE_HEADER, params.toArray(MapSqlParameterSource[]::new));
	    timer.stop();
	    System.out.print("batchUpdate -> Total time in seconds: " + timer.getTotalTimeSeconds());
	}
}
