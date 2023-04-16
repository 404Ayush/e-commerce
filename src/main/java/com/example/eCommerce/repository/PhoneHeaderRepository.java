package com.example.eCommerce.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.eCommerce.domain.PhoneHeaderRequest;
import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.domain.SellerInfo;

@Repository
public class PhoneHeaderRepository {
	
	private final String ID = "ID";
	private final String NAME = "NAME";
	private final String COLOR_OPTION = "COLOR_OPTION";
	private final String RAM_OPTION = "RAM_OPTION";
	private final String BRAND = "BRAND";
	private final String WARRANTY = "WARRANTY";
	private final String SELLER_ID = "SELLER_ID";
	private final String SELLER_NAME = "SELLER_NAME";
	private final String PRICE = "PRICE";
	private final String AVAIL_QY = "AVIAL_QY";

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String SQL_SELECT_PHONE_HEADER = "SELECT * FROM SELLER_INFO AS A INNER JOIN PHONE_HEADER AS B ON A.PHONE_ID = B.ID WHERE ID = :ID";
	
	public PhoneHeaderResponse getPhoneHeaderInfo(PhoneHeaderRequest request) {
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue(ID, request.getId());
		
		PhoneHeaderResponse response = new PhoneHeaderResponse();
		SellerInfo sellerInfo = new SellerInfo();
		List<SellerInfo> sellerInfoList = new ArrayList<>();
		
		jdbcTemplate.query(SQL_SELECT_PHONE_HEADER, parameterSource, results -> {
			
			response.setId(results.getString(ID));
			response.setName(results.getString(NAME));
			response.setColorOptions(results.getString(COLOR_OPTION));
			response.setRamOptions(results.getString(RAM_OPTION));
			response.setBrand(results.getString(BRAND));
			response.setWarranty(results.getString(WARRANTY));
			
			//add seller list logic
			sellerInfo.setId(results.getString(SELLER_ID));
			sellerInfo.setName(results.getString(SELLER_NAME));
			sellerInfo.setPrice(results.getString(PRICE));
			sellerInfo.setAvailableQy(Integer.parseInt(results.getString(AVAIL_QY)));
			sellerInfoList.add(sellerInfo);
			
			response.setSellerInfo(sellerInfoList);
			
		});
		
		return response;
	}
}
