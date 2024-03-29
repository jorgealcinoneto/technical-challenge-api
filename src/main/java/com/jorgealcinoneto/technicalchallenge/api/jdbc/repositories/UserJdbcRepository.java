package com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories;

import java.util.List;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;

public interface UserJdbcRepository{

	public List<User> findUsersByGenderAndAgeConditional(TypeGender typeGender, Integer age, String expression);

	public Integer updateStatus(TypeStatus typeStatus, Long id);

}
