package com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcRepository {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
		
}
