package com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories;

import java.util.List;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;

public class UserJdbcRepository extends JdbcRepository{

	public List<User> findByGenderAndAgeConditional(TypeGender typeGender, Integer age, String expression) {
		
		return null;
	}

}
