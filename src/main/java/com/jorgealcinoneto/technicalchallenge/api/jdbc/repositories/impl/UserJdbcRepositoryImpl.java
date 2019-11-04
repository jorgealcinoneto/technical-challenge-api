package com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;
import com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories.JdbcRepository;
import com.jorgealcinoneto.technicalchallenge.api.jdbc.repositories.UserJdbcRepository;

@Repository
public class UserJdbcRepositoryImpl extends JdbcRepository implements UserJdbcRepository{

	@Override
	public List<User> findUsersByGenderAndAgeConditional(TypeGender typeGender, Integer age, String expression) {
		
		return null;
	}

	@Override
	public Integer updateStatus(TypeStatus typeStatus, Long id) {
		
		 return this.jdbcTemplate.update(
			      "UPDATE tb_usuario SET  usuario_status = ? where usuario_id = ?", typeStatus.getValue(), id);
		
	}

}
