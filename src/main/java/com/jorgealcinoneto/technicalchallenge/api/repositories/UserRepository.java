package com.jorgealcinoneto.technicalchallenge.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jorgealcinoneto.technicalchallenge.api.entities.User;


@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
	
	//public List<User> find(); 
	
	//public List<User> findUserByGenderAndAdultAge(TypeGender typeGender);
	
	public Optional<User> findByCpf(String cpf);
	
	
	
}
