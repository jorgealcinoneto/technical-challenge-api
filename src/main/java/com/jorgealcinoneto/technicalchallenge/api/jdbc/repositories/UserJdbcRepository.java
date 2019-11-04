package com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories;

import java.util.List;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;

public class UserJdbcRepository extends JdbcRepository{

	public List<User> findByGenderAndAgeConditional(TypeGender typeGender, Integer age, String expression) {
		
		return null;
	}
	
	public void updateStatus(TypeStatus typeStatus, Long id) {
		
		
	}

}
