package com.jorgealcinoneto.technicalchallenge.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeGender;
import com.jorgealcinoneto.technicalchallenge.api.enums.TypeStatus;


public interface UserService {

	public User persist(User user);
	
	public void disable(TypeStatus typeStatus, Long id);
	
	public void remove(Long id);
	
	public List<User> listAll(Long id);
	
	List<User> findByProfileId(@Param("profileId") Long findByProfileId);
	
	List<User> findByOfficeId(@Param("officeId") Long officeId);
	
	public Optional<User> findByName(String name);
	
	public Optional<User> findByCpf(String cpf);
	
	public Optional<User> findByGender(TypeGender typeGender);
	
	
	
}
