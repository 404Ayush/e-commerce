package com.example.eCommerce.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.eCommerce.domain.ProductHomeResponse;

@Repository
public class ProductHomeRepository {
	
	private final String ID = "ID";
	private final String NAME = "NAME";
	private final String RAM_OPTION = "RAM_OPTION";
	private final String BRAND = "BRAND";
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String SQL_SELECT_PHONE_HEADER_HOME = "SELECT * FROM PHONE_HEADER LIMIT 10";
	
	public List<ProductHomeResponse> getHomeResponse() {
		
		List<ProductHomeResponse> phoneList = new ArrayList<>();
		
		jdbcTemplate.query(SQL_SELECT_PHONE_HEADER_HOME, results -> {
			ProductHomeResponse response = new ProductHomeResponse();
			response.setId(results.getString(ID));
			response.setName(results.getString(NAME));
			response.setRamOptions(results.getString(RAM_OPTION));
			response.setBrand(results.getString(BRAND));
			phoneList.add(response);
		});
		return phoneList;
	}
	
}
