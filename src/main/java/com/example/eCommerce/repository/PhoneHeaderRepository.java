package com.example.eCommerce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.eCommerce.domain.PhoneHeaderResponse;
import com.example.eCommerce.domain.SellerInfo;

@Repository
public class PhoneHeaderRepository {
	
	private final String PHONE_ID = "PHONE_ID";
	private final String NAME = "NAME";
	private final String COLOR_OPTION = "COLOR_OPTION";
	private final String RAM_OPTION = "RAM_OPTION";
	private final String BRAND = "BRAND";
	private final String WARRANTY = "WARRANTY";
	private final String SELLER_NAME = "SELLER_INFO_NAME";

	@Autowired
	JdbcTemplate template;
	
	private final String SQL_SELECT_PHONE_HEADER = "SELECT * FROM SELLER_INFO AS A INNER JOIN PHONE_HEADER AS B ON A.PHONE_ID = B.PHONE_ID where A.phone_id=1";
	
	public PhoneHeaderResponse getPhoneHeaderInfo() {
		
		PhoneHeaderResponse response = new PhoneHeaderResponse();
		SellerInfo sellerInfo = new SellerInfo();
		
		template.query(SQL_SELECT_PHONE_HEADER, results -> {
			
			response.setId(results.getInt(PHONE_ID));
			response.setName(results.getString(NAME));
			response.setColorOptions(results.getString(COLOR_OPTION));
			response.setRamOptions(results.getString(RAM_OPTION));
			response.setBrand(results.getString(BRAND));
			response.setWarranty(results.getString(WARRANTY));
			
			//sellerInfo.setName(results.getString(SELLER_NAME));
			
		});
		
		return response;
	}
}
